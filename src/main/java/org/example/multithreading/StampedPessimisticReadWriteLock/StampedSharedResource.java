package org.example.multithreading.StampedPessimisticReadWriteLock;

import java.util.concurrent.locks.StampedLock;

public class StampedSharedResource {
    private String data = "initialData";
    StampedLock lock = new StampedLock();

    public String readData() {
        long stamp = lock.readLock();
        try {
            System.out.println("reading data from current thread " + Thread.currentThread().getName()
                    + " data " + data);
            Thread.sleep(5000);
        } catch (InterruptedException _) {

        } finally {
            System.out.println("releasing lock from reading data for current thread "
                    + Thread.currentThread().getName());
            lock.unlockRead(stamp);
        }
        return data;
    }

    public void writeData(String data) {
        long stamp = lock.writeLock();
        System.out.println("Stamp " + stamp);
        try {
            this.data = data;
            System.out.println("writing data from current thread " + Thread.currentThread().getName() + " data " + data);
            Thread.sleep(7000);
        } catch (InterruptedException _) {

        } finally {
            System.out.println("releasing lock from writing data for current thread "
                    + Thread.currentThread().getName());
            lock.unlockWrite(stamp);
        }
    }

    public static void main(String[] args) {
        StampedSharedResource resource = new StampedSharedResource();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                resource.readData();
            }, "ReadThread-" + i).start();
        }

        //here sleep is added to avoid read operation to happen before write.
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread writer1 = new Thread(() -> {
            resource.writeData("updated data");
        }, "writer 1");


        Thread reader4 = new Thread(() -> {
            resource.readData();
        }, "ReadThread-4");

        writer1.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        reader4.start();


        Thread writer2 = new Thread(() -> {
            resource.writeData("updated new data");
        }, "writer 2");

        Thread reader5 = new Thread(() -> {
            resource.readData();
        }, "ReadThread-5");

        //here sleep is added to avoid read operation to happen before write.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        /**
         * if multiple threads currently hold the read lock of a ReentrantReadWriteLock,
         * another thread cannot acquire the write lock.
         */
        writer2.start();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        reader5.start();
    }
}

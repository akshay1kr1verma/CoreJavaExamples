package org.example.multithreading.ReentrantReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResource {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private String data = "Initial Data";

    public void readData() {
        lock.readLock().lock();
        System.out.println("currently executing thread from read operation " + Thread.currentThread().getName()
                + " data value: " + data);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void writeData(String data) {
        lock.writeLock().lock();
        try {
            System.out.println("currently executing thread from write operation " + Thread.currentThread().getName()
                    + " data " + data);
            this.data = data;
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("completed execution of thread from write operation " + Thread.currentThread().getName());
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        // Create multiple reader threads
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                sharedResource.readData();
            }, "Reader-" + (i + 1)).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        // Create a writer thread
        new Thread(() -> {
            sharedResource.writeData(" new data");
        }, "Writer-1").start();

        // Create another reader thread after the writer

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        Thread read = new Thread(() -> {
            sharedResource.readData();
        }, "Reader-4");
        System.out.println("trying to perform read operation for " + Thread.currentThread().getName());
        read.start();
    }
}

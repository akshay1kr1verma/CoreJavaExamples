package org.example.multithreading.ProducerConsumerReentrantLock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantAwaitSignalSharedResource {
    private final Queue<Integer> buffer = new LinkedList<>();
    private final int bufferSize;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition bufferFull = lock.newCondition();
    private final Condition bufferEmpty = lock.newCondition();

    public ReentrantAwaitSignalSharedResource(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    public void addItem(int item) {
        lock.lock();
        try {
            if (buffer.size() == bufferSize) {
                System.out.println("size is full " + Thread.currentThread().getName());
                bufferFull.await();
            }
            buffer.add(item);
            System.out.println("buffer item produced : " + item + " " + Thread.currentThread().getName());
            bufferEmpty.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public int removeItem() {
        lock.lock();
        try {
            if (buffer.isEmpty()) {
                System.out.println("buffer is empty " + Thread.currentThread().getName());
                bufferEmpty.await();
            }
            int item = buffer.poll();
            System.out.println("buffer item consumer : " + item + " " + Thread.currentThread().getName());
            bufferFull.signal();
            return item;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
       ReentrantAwaitSignalSharedResource sharedResource = new ReentrantAwaitSignalSharedResource(3);
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                sharedResource.addItem(i);
            }
        }, "producer thread").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedResource.removeItem();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "consumer-thread1").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedResource.removeItem();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "consumer-thread2").start();
    }

}

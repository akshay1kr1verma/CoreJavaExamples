package org.example.multithreading.ReentrantLock;

import java.time.LocalTime;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable = false;
    ReentrantLock lock = new ReentrantLock();

    public void producer() {
        try {
            lock.lock();
            isAvailable = true;
            System.out.println("Lock acquired by " + Thread.currentThread().getName() + " time :" + LocalTime.now());
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
            System.out.println("Lock released by " + Thread.currentThread().getName() + " time :" + LocalTime.now());
        }
    }
}

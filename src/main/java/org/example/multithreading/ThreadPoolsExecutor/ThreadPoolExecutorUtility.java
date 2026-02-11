package org.example.multithreading.ThreadPoolsExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorUtility {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        threadPool.submit(() -> {
            System.out.println("This is async task executed by thread :" + Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        ExecutorService threadPool2 = Executors.newCachedThreadPool();
        for (int i = 0; i < 2; i++) {
            threadPool2.submit(() -> {
                System.out.println("This is newCachedThreadPool async task executed by thread :" + Thread.currentThread().getName());
            });
        }

        ExecutorService threadPool3 = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 2; i++) {
            threadPool3.submit(() -> {
                System.out.println("This is newSingleThreadExecutor async task executed by thread :" + Thread.currentThread().getName());
            });
        }

        threadPool.shutdown();
        System.out.println("Main thread unblocked");
        //immediate shut down seen when used shutdown now.
        //threadPool.shutdownNow();
        //System.out.println("Main thread unblocked2");

        try {
            //here code will wait for 3 sec and hold the execution of next line at 42.
            boolean terminationCompleted = threadPool.awaitTermination(3, TimeUnit.SECONDS);
            System.out.println("terminationCompleted : " + terminationCompleted);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        threadPool2.shutdown();
        threadPool3.shutdown();

    }
}

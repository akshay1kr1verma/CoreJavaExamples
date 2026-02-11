package org.example.multithreading.ThreadPoolsExecutor;

import java.util.concurrent.*;

public class CustomScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService poolExecutor = Executors.newScheduledThreadPool(5);
        poolExecutor.schedule(() -> {
            System.out.println("Thread executing : "+ Thread.currentThread().getName());
        }, 5, TimeUnit.SECONDS);
        Future<String> futureObj = poolExecutor.schedule(() -> {
            return "Thread executing : "+ Thread.currentThread().getName();
        }, 5, TimeUnit.SECONDS);

        try {
            System.out.println(futureObj.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        /*poolExecutor.scheduleAtFixedRate(() -> {
            System.out.println("hello thread " + Thread.currentThread().getName());
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, 5, 5, TimeUnit.SECONDS);*/


        poolExecutor.scheduleWithFixedDelay(() -> {
            System.out.println("hello thread " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, 5, 1, TimeUnit.SECONDS);
    }
}

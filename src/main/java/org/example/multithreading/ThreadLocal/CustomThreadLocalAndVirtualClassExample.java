package org.example.multithreading.ThreadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomThreadLocalAndVirtualClassExample {
    public static void main(String[] args) {
        ThreadLocal<String> tl1 = new ThreadLocal<>();
        ExecutorService poolExecutor = Executors.newFixedThreadPool(50);
        for (int i = 1; i < 10; i++) {
            poolExecutor.submit(() -> {
                //set method used figures out the executing thread and then use it's thread local class to set the field.
                System.out.println("thread name : " + Thread.currentThread().getName());
                tl1.set("TL1 Thread name : " + Thread.currentThread().getName());
                System.out.println(tl1.get());
            });
        }

        poolExecutor.shutdown();

        //Virtual Thread
        Thread virtualThread = Thread.ofVirtual().name("Virtual Thread 1").start(() -> {
            System.out.println("Thread name : "+ Thread.currentThread().getName());
        });

        //VirtualThreadPoolExecutor
        ExecutorService virtualPoolExecutor = Executors.newVirtualThreadPerTaskExecutor();
        virtualPoolExecutor.submit(() ->
        {
            System.out.println("Thread name : " + Thread.currentThread().getName());
        });
    }
}

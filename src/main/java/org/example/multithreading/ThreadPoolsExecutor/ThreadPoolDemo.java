package org.example.multithreading.ThreadPoolsExecutor;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Available cores: " + cores);

        ExecutorService pool = Executors.newFixedThreadPool(cores);



        for (int i = 0; i < cores * 2; i++) { // double the tasks
            int task = i;
            pool.submit(() -> {
                System.out.println("Task " + task + " running on " +
                        Thread.currentThread().getName());
            });
        }

        pool.shutdown();

        IntStream.range(1, 200000)
                .parallel()
                .forEach(i -> {
                    System.out.println("Task " + i + " by " +
                            Thread.currentThread().getName());
                });
    }
}


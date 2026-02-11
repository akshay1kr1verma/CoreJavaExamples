package org.example.multithreading.ThreadPoolsExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CustomThreadPoolExecutorFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                5, 10, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        poolExecutor.allowCoreThreadTimeOut(true);
        Future<?> futureObj = poolExecutor.submit(() -> {
                    try {
                        Thread.sleep(7000);
                        System.out.println("this is the task, which thread will execute");
                    } catch (Exception e) {
                    }
                }
        );
        System.out.println("is done : " + futureObj.isDone());

        try {
            futureObj.get(2, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            System.out.println("Timeout exception happened");
        } catch (Exception e) {
        }


        try {
            futureObj.get();
        } catch (InterruptedException | ExecutionException e) {

        }

        System.out.println("Future obj is done : " + futureObj.isDone());
        System.out.println("Future obj is canceled : " + futureObj.isCancelled());


        //Pool executor

        Future<?> futureObj1 = poolExecutor.submit(() -> {
            System.out.println("Task1 with runnable");
        });
        try {
            Object object = futureObj1.get();
            System.out.println(object == null);
        } catch (Exception e) {

        }

        //use case2
        List<Integer> output = new ArrayList<>();
        Future<List<Integer>> futureObj2 = poolExecutor.submit(() -> {
            output.add(100);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println("Task 2 with runnable and return object thread :" + Thread.currentThread().getName());
        }, output);

        try {
            List<Integer> outputFutureObject2 = futureObj2.get();
            System.out.println(outputFutureObject2.get(0));
        } catch (Exception e) {

        }

        //use case3
        Future<List<Integer>> futureObj3 = poolExecutor.submit(() -> {
            List<Integer> listObj = new ArrayList<>();
            listObj.add(200);
            System.out.println("Task 3 with callable thread :" + Thread.currentThread().getName());
            return listObj;
        });

        try {
            List<Integer> outputFutureObject3 = futureObj3.get();
            System.out.println(outputFutureObject3.get(0));
        } catch (Exception e) {

        }

        //CompletableFuture
        CompletableFuture<String> asynctask1 = CompletableFuture.supplyAsync(() -> {
            return "completable future task completed";
        }, poolExecutor);

        try {
            System.out.println(asynctask1.get());
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        //CompletableFuture with thenApply
        CompletableFuture<String> asynctask2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("asynctask thread :" + Thread.currentThread().getName());
            return "completable future task completed";
        }, poolExecutor).thenApply((String val) -> {
            System.out.println("thenApply thread :" + Thread.currentThread().getName());
            return val + " coding";
        });

        try {
            System.out.println(asynctask2.get());
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        //CompletableFuture with thenApplyAsync
        CompletableFuture<String> asynctask3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("asynctask thread :" + Thread.currentThread().getName());
            return "completable future task completed ";
        }, poolExecutor).thenApplyAsync((String val) -> {
            System.out.println("thenApplyAsync thread :" + Thread.currentThread().getName());
            return val + " coding";
        }, poolExecutor);

        try {
            System.out.println(asynctask3.get());
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println(" ");
        System.out.println(" ");
        //CompletableFuture with thenCompose
        CompletableFuture<String> asynctask4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("asynctask4 thread :" + Thread.currentThread().getName());
            return "completable future task completed";
        }, poolExecutor).thenCompose((String val) -> {
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("thenCompose thread :" + Thread.currentThread().getName());
                return val + " coding as thencompose";
            }, poolExecutor);
        });

        try {
            System.out.println(asynctask4.get());
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println(" ");
        System.out.println(" ");
        //CompletableFuture with thenComposeAsync
        CompletableFuture<String> asynctask5 = CompletableFuture.supplyAsync(() -> {
            System.out.println("asynctask5 thread :" + Thread.currentThread().getName());
            return "completable future task completed ";
        }, poolExecutor).thenComposeAsync((String val) -> {
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("thenComposeAsync thread : " + Thread.currentThread().getName());
                return val + "then compose async";
            }, poolExecutor);
        }, poolExecutor);

        try {
            System.out.println(asynctask5.get());
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


        System.out.println(" ");
        System.out.println(" ");
        //CompletableFuture with thenAccept
        CompletableFuture<Void> asynctask6 = CompletableFuture.supplyAsync(() -> {
            System.out.println("asynctask6 thread :" + Thread.currentThread().getName());
            return "completable future task completed";
        }, poolExecutor).thenAccept((String val) -> {
                System.out.println("val::" +  val + " then accept thread :" + Thread.currentThread().getName());
            });

        try {
            System.out.println(asynctask6.get());
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println(" ");
        System.out.println(" ");
        //CompletableFuture with thenCompose

        CompletableFuture<Integer> asynctask7 = CompletableFuture.supplyAsync(() -> {
            return 100;
        }, poolExecutor);
        CompletableFuture<String> asynctask8 = CompletableFuture.supplyAsync(() -> {
            return "akshay";
        }, poolExecutor);
        CompletableFuture<String> asynctaskCombine = asynctask7.thenCombine(asynctask8, (Integer i, String s)-> s + i);
        System.out.println(asynctaskCombine.get());
        poolExecutor.shutdown();

        ThreadPoolExecutor testPool = new ThreadPoolExecutor(3,4,1000,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        CompletableFuture.supplyAsync(() -> {
            return " hello from supply async ";
        }, testPool)
                .thenApplyAsync((String supplyAsyncName) -> {
                        return supplyAsyncName + " hello from then apply ";}, testPool)
                .thenCompose(nameFromApply -> {
                    return CompletableFuture.supplyAsync(() -> {
                        return nameFromApply + " hello from thenCompose ";
                    }, testPool);})
                .thenAccept((String nameFromAccept) -> {
                           System.out.println(nameFromAccept + "hello from thenaccept");
                    });

    }
}

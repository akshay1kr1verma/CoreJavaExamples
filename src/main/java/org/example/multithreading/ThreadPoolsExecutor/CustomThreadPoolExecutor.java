package org.example.multithreading.ThreadPoolsExecutor;

import java.util.concurrent.*;

public class CustomThreadPoolExecutor {
    public static void main(String[] args) {
        try {
            ThreadPoolExecutor poolExecutor =
                    new ThreadPoolExecutor(2, 4, 1,
                            TimeUnit.SECONDS, new ArrayBlockingQueue<>(2),  new CustomThreadFactory(),
                            new CustomRejectedHandler());
            poolExecutor.allowCoreThreadTimeOut(true);
            for (int i = 1; i < 25; i++) {
                poolExecutor.submit(() -> {
                    try {
                        Thread.sleep(1000);
                        System.out.println("executing Thread name : " + Thread.currentThread().getName());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            }

            poolExecutor.shutdown();
        } catch (Exception _) {

        }

    }
}

class CustomThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        return t;
    }
}

class CustomRejectedHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, java.util.concurrent.ThreadPoolExecutor executor) {
        System.out.println("Task denied: " + r.toString());
    }
}

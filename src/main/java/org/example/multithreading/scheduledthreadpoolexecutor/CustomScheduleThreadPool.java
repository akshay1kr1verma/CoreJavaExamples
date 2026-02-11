package org.example.multithreading.scheduledthreadpoolexecutor;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CustomScheduleThreadPool {
    public static void main(String args[]) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        Runnable runnableTask = () -> {
            System.out.println("before thread sleep, current running task :: " + Thread.currentThread().getName()
                    + " Time unit :: " + LocalTime.now());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("after thread sleep, current running task :: " + Thread.currentThread().getName()
                    + " Time unit :: " + LocalTime.now());
        };
        executor.scheduleAtFixedRate(runnableTask, 1, 3, TimeUnit.SECONDS);
        //executor.shutdown();
    }
}

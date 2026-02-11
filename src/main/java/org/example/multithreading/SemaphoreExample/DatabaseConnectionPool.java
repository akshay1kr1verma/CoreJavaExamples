package org.example.multithreading.SemaphoreExample;

import java.util.concurrent.Semaphore;

public class DatabaseConnectionPool {
    private final Semaphore semaphore = new Semaphore(3, true);

    public void connect() {
        try{
        semaphore.acquire();
        System.out.println("Current Thread acquired lock  " + Thread.currentThread().getName());
        Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Current Thread released lock  " + Thread.currentThread().getName());
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        DatabaseConnectionPool databaseConnectionPool = new DatabaseConnectionPool();

            for(int i=0; i <10; i++) {
                new Thread(databaseConnectionPool::connect, "SemaphoreThread-" + i).start();
            }
    }
}

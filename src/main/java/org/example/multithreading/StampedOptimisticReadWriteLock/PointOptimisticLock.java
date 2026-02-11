package org.example.multithreading.StampedOptimisticReadWriteLock;

import java.util.concurrent.locks.StampedLock;

public class PointOptimisticLock {
    private double x, y;
    StampedLock sl = new StampedLock();

    public PointOptimisticLock(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceFromOrigin() {
        long stamp = sl.tryOptimisticRead();// 1. Attempt optimistic read
        System.out.println("attempting optimistic read");
        double currentX = x;
        double currentY = y;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (!sl.validate(stamp)) {// 2. Validate the stamp
            // Optimistic read failed, acquire a full read lock
            System.out.println("validation failed, for read, acquiring lock now.");
            stamp = sl.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

    public void move(double deltaX, double deltaY) {
        long stamp = sl.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    public static void main(String[] args) {
        PointOptimisticLock p = new PointOptimisticLock(2, 3);
        //reader thread
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Distance from origin: " + p.distanceFromOrigin());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException _) {

                }
            }
        }).start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Writer thread
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                p.move(1, 1);
                System.out.println("Point moved.");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}

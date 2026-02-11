package org.example.multithreading.monitorlock;

public class MonitorLockExample {

    public synchronized void task1() {
        try {
            System.out.println("task1 getting executed");
            Thread.sleep(5000);
        } catch (Exception _) {

        }
    }

    public void task2() {
        System.out.println("before getting into synchronized area of task2");
        synchronized (this) {
            System.out.println("after getting into synchronized area of task2");
        }
    }

    public void task3() {
        System.out.println("task3 getting executed");
    }

    public static void main(String[] args) {
        MonitorLockExample obj = new MonitorLockExample();
        Thread t1 = new Thread(obj::task1);
        Thread t2 = new Thread(obj::task2);
        Thread t3 = new Thread(obj::task3);

        t1.start();
        t2.start();
        t3.start();
    }
}

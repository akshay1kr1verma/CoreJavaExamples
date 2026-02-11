package org.example.multithreading.suspendresume;

public class JoinMethodMain {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread t1 = new Thread(() -> {
        sharedResource.produce();
            System.out.println("T1 thread completed");
        });
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException _) {
        }
        System.out.println("Main thread completed");
    }
}

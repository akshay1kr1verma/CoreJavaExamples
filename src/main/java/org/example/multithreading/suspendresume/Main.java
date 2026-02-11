package org.example.multithreading.suspendresume;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread producer1 = new Thread(() -> {
            System.out.println("Producer1 getting called");
            sharedResource.produce();
        });
        Thread producer2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException _) {
            }
            System.out.println("Producer2 getting called");
            sharedResource.produce();
        });

        producer1.start();
        producer2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException _) {
        }
    }
}

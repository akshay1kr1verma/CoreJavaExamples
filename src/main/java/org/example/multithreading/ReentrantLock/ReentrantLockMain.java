package org.example.multithreading.ReentrantLock;

import org.example.multithreading.ReentrantLock.SharedResource;

public class ReentrantLockMain {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        for (int i = 1; i < 4; i++){
            new Thread(() -> {
                sharedResource.producer();
            }).start();
        }
    }
}

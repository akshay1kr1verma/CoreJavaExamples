package org.example.multithreading.SynchronizedItemAvailableSharedResource;

public class ConsumeTask implements Runnable {

    SharedResource sharedResource;

    public ConsumeTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println("ConsumeTask executed by " + Thread.currentThread().getName());
        sharedResource.consumeItem();
    }
}
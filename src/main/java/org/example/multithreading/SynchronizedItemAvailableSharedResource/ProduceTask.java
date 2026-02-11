package org.example.multithreading.SynchronizedItemAvailableSharedResource;

public class ProduceTask implements Runnable {

    SharedResource sharedResource;

    public ProduceTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println("ProduceTask executed by " + Thread.currentThread().getName());
        try{
        Thread.sleep(5000);
        } catch (Exception _) {

        }
        sharedResource.addItem();
    }
}

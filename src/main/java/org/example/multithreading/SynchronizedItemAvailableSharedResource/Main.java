package org.example.multithreading.SynchronizedItemAvailableSharedResource;

public class Main {
    public static void main(String [] args){
        SharedResource sharedResource = new SharedResource();
        ProduceTask produceTask = new ProduceTask(sharedResource);
        ConsumeTask consumeTask = new ConsumeTask(sharedResource);

        Thread t1 = new Thread(produceTask);
        Thread t2 = new Thread(consumeTask);

        t1.start();
        t2.start();
    }
}

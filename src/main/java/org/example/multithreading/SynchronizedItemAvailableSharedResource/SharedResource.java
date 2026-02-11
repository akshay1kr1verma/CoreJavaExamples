package org.example.multithreading.SynchronizedItemAvailableSharedResource;

public class SharedResource {

    boolean itemAvailable = false;

    public synchronized void addItem() {
        itemAvailable = true;
        System.out.println("add item executed by " + Thread.currentThread().getName()
                + " and invoking all threads which are waiting");
        notifyAll();
    }

    public synchronized void consumeItem() {
        System.out.println("we are consuming item executed by " + Thread.currentThread().getName());

        while (!itemAvailable) {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting now");
                wait();
            } catch (Exception _) {
            }
        }
        System.out.println("Item consumed by " + Thread.currentThread().getName());
        itemAvailable = false;
    }
}

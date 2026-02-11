package org.example.multithreading.suspendresume;

public class SharedResource {
    private boolean isFlagEnabled = false;

    public synchronized void produce() {
        isFlagEnabled = true;
        System.out.println("Shared resource flag is enabled now. Lock acquired by thread ::" +
                Thread.currentThread().getName());
        try {
            Thread.sleep(8000);
        } catch (InterruptedException _) {
        }
        System.out.println("Lock released");
    }
}

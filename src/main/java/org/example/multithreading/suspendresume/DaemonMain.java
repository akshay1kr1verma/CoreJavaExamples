package org.example.multithreading.suspendresume;

public class DaemonMain {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread daemonThread = new Thread(() ->
        {
            sharedResource.produce();
        });
        daemonThread.setDaemon(true);
        daemonThread.start();
        //without join daemon thread may not complete as it waits only till last user thread active. So,
        // when main is completed daemon thread will stop abruptly.
        /*try {
            daemonThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        System.out.println("We are in main method");
    }
}

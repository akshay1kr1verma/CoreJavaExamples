package org.example.multithreading.producerconsumerproblem;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    private Queue<Integer> sharedBuffer;
    private int bufferSize;

    public SharedResource(int bufferSize) {
        this.sharedBuffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void addItem(int item) {
        if (sharedBuffer.size() == bufferSize) {
            try {
                System.out.println("Buffer is full, producer is waiting for consumer thread ");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        sharedBuffer.add(item);
        System.out.println("added item by producer :: " + item);
        notifyAll();
    }

    public synchronized int consumeItem() {
        if (sharedBuffer.isEmpty()) {
            try {
                System.out.println("Buffer is empty, consumer is waiting for producer");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int item = sharedBuffer.poll();
        System.out.println("consumed item :" + item);
        notifyAll();
        return item;
    }
}

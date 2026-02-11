package org.example.multithreading.producerconsumerproblem;

public class ProducerConsumerLearning {


    public static void main(String [] args){
        SharedResource sharedResource = new SharedResource(3);
        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    sharedResource.addItem(i);
                }
            } catch (Exception _) {
                //handle exception here
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    sharedResource.consumeItem();
                }
            } catch (Exception _) {
                //handle exception here
            }
        });
        producerThread.start();
        consumerThread.start();
    }
}

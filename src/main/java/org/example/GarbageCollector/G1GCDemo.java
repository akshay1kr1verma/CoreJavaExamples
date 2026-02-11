package org.example.GarbageCollector;

public class G1GCDemo {
    public static void main(String[] args) {

        for (int i = 0; i < 2_000_000; i++) {
            byte[] obj = new byte[1024];
        }//total bytes used here 200 mb

        System.gc();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        byte[] largeArray = new byte[100 * 1024 * 1024]; //one object of 100 mb size
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Allocate more objects after garbage collection

        for (int i = 0; i < 1_000_000; i++) {
            byte[] obj = new byte[2048];
        }//200 mb used here as well

        System.gc();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

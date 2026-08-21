package org.example.GarbageCollector;

import java.util.concurrent.*;

/**
 * ThreadLocal Memory Leak Demo for JVisualVM Profiling
 */
public class ThreadLocalLeakDemo {

    // The ThreadLocal variable used to store data per-thread
    private static final ThreadLocal<byte[]> contextHolder = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        // Create a pool with exactly ONE thread to guarantee thread reuse
        ExecutorService threadPool = Executors.newFixedThreadPool(1);

        // ==========================================
        // TASK 1: THE LEAKING TASK
        // ==========================================
        threadPool.submit(() -> {
            System.out.println("[Task 1] Running on: " + Thread.currentThread().getName());

            // Allocate 50 Megabytes of data
            byte[] bigData = new byte[1024 * 1024 * 50];
            contextHolder.set(bigData);

            System.out.println("[Task 1] Loaded 50MB into ThreadLocal.");
            System.out.println("[Task 1] CRITICAL ERROR: Forgetting to call remove()...");
            System.out.println("[Task 1] Finished. Thread goes back to pool.\n");
        });

        // Wait for Task 1 to completely finish
        Thread.sleep(2000);

        // ==========================================
        // FORCE GARBAGE COLLECTION
        // ==========================================
        System.out.println("[System] Running Garbage Collector...");
        System.gc();
        printMemoryUsage("After Task 1 (Leaked)");

        // ==========================================
        // TASK 2: THE FIXED TASK (Production Pattern) if we run below code the memory corrects itself to 1 mb as we have used contextHolder.remove();
        // ==========================================
        /*threadPool.submit(() -> {
            System.out.println("\n[Task 2] Running on SAME thread: " + Thread.currentThread().getName());

            try {
                // Allocate another 20 Megabytes of data safely
                byte[] safeData = new byte[1024 * 1024 * 20];
                contextHolder.set(safeData);
                System.out.println("[Task 2] Loaded 20MB safely into ThreadLocal.");

                // Do your application logic here...

            } finally {
                // THE FIX: This safely wipes both the key and value from the thread's map
                contextHolder.remove();
                System.out.println("[Task 2] Cleaned up ThreadLocal via finally block.");
            }
        });

        // Wait for Task 2 to completely finish
        Thread.sleep(2000);

        System.out.println("\n[System] Running Garbage Collector again...");
        System.gc();
        printMemoryUsage("After Task 2 (Cleaned)");*/

        // ==========================================
        // PAUSE FOR JVISUALVM PROFILING
        // ==========================================
        System.out.println("\n[System] Program paused. Open JVisualVM now!");
        System.out.println("[System] Look for 'ThreadLocalLeakDemo' in the applications list.");

        // This keeps the JVM process alive so you can inspect the heap dump
        Thread.sleep(Long.MAX_VALUE);

        // Shut down the pool (unreachable due to infinite sleep above)
        threadPool.shutdown();
    }

    /**
     * Utility method to print current memory status to the console
     */
    private static void printMemoryUsage(String stage) {
        Runtime runtime = Runtime.getRuntime();
        long usedMemory = (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);
        System.out.println("[Memory] Used Heap (" + stage + "): " + usedMemory + " MB");
    }
}


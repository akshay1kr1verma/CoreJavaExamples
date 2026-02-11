package org.example.multithreading.ThreadPoolsExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolExecutorService {
    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        Future<Integer> futureObj = forkJoinPool.submit(new ComputeSumTask(1, 100));
        try {
            System.out.println("result : " + futureObj.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

class ComputeSumTask extends RecursiveTask<Integer> {
    int start, end;

    ComputeSumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        System.out.println("start/end : " + start + "/" + end + " Thread executing : "
                + Thread.currentThread().getName());
        if ((end - start) <= 4) {
            int totalSum = 0;
            for (int i = start; i <= end; i++) {
                totalSum += i;
            }
            return totalSum;
        } else {
            int mid = (start + end) / 2;
            ComputeSumTask leftTask = new ComputeSumTask(start, mid - 1);
            ComputeSumTask rightTask = new ComputeSumTask(mid, end);
            //fork for parallel execution
            leftTask.fork();
            rightTask.fork();

            //combine the result of subtasks
            int leftResult = (int) leftTask.join();
            int rightResult = (int) rightTask.join();
            return leftResult + rightResult;
        }
    }
}

package com.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolDemo {

    public static void main(String[] args) throws Exception{
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        int size = 10000000;
        int[] arr = new int[size];

        for (int i = 0; i < 1000; i++) {
            int random = (int)(Math.random() * 1000);
            arr[i] = random;
        }
        ComputeTask task = new ComputeTask(arr, 0, size);
        Future<Integer> forkSum =  forkJoinPool.submit(task);

        forkJoinPool.shutdown();
    }
}

class ComputeTask extends RecursiveTask<Integer> {

    private static final int threshold = 50;
    private int start;
    private int end;
    private int[] arr;

    ComputeTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        if (start < end && end - start < threshold) {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            return sum;
        } else {
            int middle = (start + end) / 2;

            ComputeTask left = new ComputeTask(arr, start, middle);
            ComputeTask right = new ComputeTask(arr, middle , end);

            left.fork();
            right.fork();
            return left.join() + right.join();
        }
    }
}

package com.icode.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class Sum extends RecursiveTask<Long> {

    int[] arr;
    int low;
    int high;

    public Sum(int[]arr, int low, int high) {
        this.arr = arr;
        this.low = low;
        this.high = high;
    }

    @Override
    protected Long compute() {

        if ((high - low) <= 10) {
            long sum = 0;
            for (int i = low ; i <=high; i++) {
                sum += arr[i];
            }
            return sum;
        }

        int mid = (low + high)/2;

        Sum left = new Sum(arr, low, mid);
        Sum right = new Sum(arr, mid, high);
        return left.join() + right.join();
    }
}

public class ForkJoinDemo {

    public static void main(String[] args) {

        int[] nums = new int[1000];
        int nProcessor = Runtime.getRuntime().availableProcessors();
        System.out.println("Total Processors: "+ nProcessor);
        int j = 0;
        for(int i = 1; i <=1000; i++) {
            nums[j++] = i;
        }

        ForkJoinPool forkJoinPool = new ForkJoinPool(nProcessor);
        Long result = forkJoinPool.invoke(new Sum(nums, 0, nums.length));
        System.out.println("Fork join result: "+result);
    }
}

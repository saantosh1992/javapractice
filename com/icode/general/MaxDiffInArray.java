package com.icode.general;

public class MaxDiffInArray {

    public static void main(String[] args) {

        int arr[] = {1, 2, 90, 10, 110};
        int maxDiff = maxDiffernece(arr);
        System.out.println(maxDiff);
    }

    private static int maxDiffernece(int[] arr) {

        int maxDiff = Integer.MIN_VALUE;
        int min = arr[0];

        for(int i = 1; i < arr.length; i++) {

            if(arr[i] - min > maxDiff) {
                maxDiff = arr[i] - min;
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return maxDiff;
    }
}

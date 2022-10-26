package com.icode.array;

import java.util.Arrays;

public class FindFirstLastInSortedArray {
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int target = 8;

        int[] pos = searchFirstLastPosition(arr, target);
        System.out.println("Found:"+ Arrays.toString(pos));
    }

    private static int[] searchFirstLastPosition(int[] arr, int target) {
        int ans1 = -1;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                ans1 = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        int ans2 = -1;
        low = 0;
        high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                ans2 = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return new int[] {ans1, ans2};
    }
}

package com.icode.array;

import java.util.Arrays;

public class FindFirstLastElementInSortedArray {

    public static void main(String[] args) {

        int[] arr = {5,7,7,8,8,10};
        int target = 8;

        int[] matched = searchRange(arr, target);
        System.out.println(Arrays.toString(matched));
    }

    private static int[] searchRange(int[] arr, int target) {

        if(arr.length == 0) {
            return new int[] {-1, -1};
        }

        return searchElement(arr, 0, arr.length-1, target);
    }

    private static int[] searchElement(int[] arr, int low, int high, int target) {

        while (low < high) {

            int mid = (low + high)/2;

            if (arr[mid] == target) {

                if (arr[low] == target && arr[high] == target) {
                    break;
                }

                if(arr[low] != target) {
                    low++;
                }

                if(arr[high] != target) {
                    high--;
                }
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (arr[low] != target || arr[high] != target){
            low = -1;
            high = -1;
        }

        return new int[] {low, high};
    }
}

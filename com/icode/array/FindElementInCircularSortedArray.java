package com.icode.array;

public class FindElementInCircularSortedArray {

    public static void main(String[] args) {
        int[] arr = { 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 3;
        int index = search(arr, 0, arr.length-1, key);
        System.out.println(index);
    }

    private static int search(int[] arr, int low, int high, int key) {

        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;

        if(arr[mid] == key) {
            return mid;
        }

        // if it's true, it means low to mid is sorted.
        if (arr[low] <= arr[mid]) {

            if ( key >= arr[low] && key <= arr[mid]) {
                return search(arr, low, mid-1, key);
            }
            return search(arr, mid + 1, high, key);
        }
        // mid to high will be sorted.
        if ( key >= arr[mid] && key <= arr[high]) {
            return search(arr, mid + 1, high, key);
        }
        return search(arr, low, mid -1, key);
    }
}

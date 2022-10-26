package com.icode.general;

import java.util.Arrays;

public class RemoveDuplicateInSorted {

    public static void main(String[] args) {

        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicate(arr);
    }

    private static void removeDuplicate(int[] arr) {
        int n = arr.length;
        int k = 1;
        for(int i = 1; i < n; i++) {
            if (arr[i-1] != arr[i]) {
                arr[k] = arr[i];
                k++;
            }
        }

        for( int j =k; j<n; j++) {
            arr[j] = 0;
        }

        System.out.println("Total elements:"+k);
        System.out.println("Array:"+ Arrays.toString(arr));
    }
}

package com.icode.general;

import java.util.HashSet;
import java.util.Set;

public class FindMissingPositive {

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};

        int missingSmallestNum = findMissingSmallestPositive(arr);

        int SmallestNum = findMissingSmallestPositiveEfficient(arr);

        System.out.println(missingSmallestNum);
        System.out.println("Efficient:"+SmallestNum);
    }

    private static int findMissingSmallestPositiveEfficient(int[] arr) {
        int n = arr.length;
        boolean isContainsOne = false;

        for(int i =0; i < n; i++) {
            if(arr[i] == 1) {
                isContainsOne = true;
                break;
            }
        }

        if(!isContainsOne) {
            return 1;
        }

        if (isContainsOne && n == 1) {
            return 2;
        }

        // if val <= 0 or val > n then make it 1

        for (int i = 0; i < n; i++) {

            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = 1;
            }
        }

        for(int i = 0; i < n; i++) {
            int x = Math.abs(arr[i]);
             if (arr[ x -1 ] > 0 ) {
                 arr[x - 1] = arr[x-1] * -1;
             }
        }

        for(int i = 0 ; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;

    }

    private static int findMissingSmallestPositive(int[] arr) {

        Set<Integer> numSet = new HashSet<>();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                numSet.add(arr[i]);
            }
        }

        for(int j = 1; j < arr.length + 1; j++) {

            if(!numSet.contains(j)){
                return j;
            }
        }

        return -1;
    }
}

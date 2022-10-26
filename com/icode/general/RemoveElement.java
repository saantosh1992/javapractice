package com.icode.general;

public class RemoveElement {

    public static void main(String[] args) {

        int[] arr = {0,1,2,2,3,0,4,2};
        int k = 2;

        removeElement(arr, k);
    }

    private static void removeElement(int[] arr, int val) {

        int k = 0;
        int count = 0;

        for(int i = 0; i < arr.length; i++) {

            if(arr[i] != val) {
                arr[k++] = arr[i];
                count++;
            }
        }
    }
}

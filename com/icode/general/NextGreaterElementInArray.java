package com.icode.general;

import java.util.Stack;

public class NextGreaterElementInArray {

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};

        printNextGreaterElement(arr);
    }

    private static void printNextGreaterElement(int[] arr) {
        // {4, 5, 2, 25}
        int n = arr.length;
        int[] nge = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        nge[n-1] = -1;
        stack.push(arr[n-1]);

        for(int i = arr.length - 2; i >=0; i--) {

            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                    stack.pop();
            }

            if (stack.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] +"-->"+nge[i]);
        }
    }
}

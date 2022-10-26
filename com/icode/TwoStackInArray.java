package com.icode;

public class TwoStackInArray {

    private int size;
    private int top1;
    private int top2;
    int[] arr;


    public TwoStackInArray(int n) {
        arr = new int[n];
        size = n;
        top1 = -1;
        top2 = size;
    }

    public void push1(int val) {

        if (top1 < top2 -1) {
            arr[++top1] = val;
        } else {
            System.out.println("Stack overflow");
            return;
        }
    }

    public void push2(int val) {
        if (top1 < top2 - 1) {
            arr[--top2] = val;
        } else {
            System.out.println("Stack overflow");
            return;
        }
    }

    public int pop1() {
        if (top1 >= 0) {
            int x = arr[top1];
            top1--;
            return x;
        } else {
            System.out.println("Stack is underflow");
            return 0;
        }
    }

    public int pop2() {
        if (top2 < size) {
            int x = arr[top2];
            top2++;
            return x;
        } else {
            System.out.println("Stack is underflow");
            return 0;
        }

    }

    public static void main(String[] args) {

        TwoStackInArray stacks = new TwoStackInArray(4);
        stacks.push1(1);
        stacks.push1(2);
        stacks.push1(3);
        stacks.push2(4);

        int val = stacks.pop2();
        System.out.println(val);

    }
}

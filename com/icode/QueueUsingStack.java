package com.icode;


import java.util.Stack;

// 1 , 2 -> 1 2 -

// 1 2 3-  stack1 - 3 - stack2 - 3,1,2 3


class MyQueue {


    private Stack<Integer> stack1 = new Stack<>();
     private Stack<Integer> stack2 = new Stack<>();

    public Integer deque() {

        if (stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.add(stack1.pop()); // 1, 2
            }
        }

        return stack2.pop();
    }

    public void enque(Integer element) {
        stack1.add(element);
    }
}
public class QueueUsingStack {

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();
        myQueue.enque(1);
        myQueue.enque(2);
        myQueue.enque(3);

        System.out.println(myQueue.deque());
        System.out.println(myQueue.deque());
        System.out.println(myQueue.deque());
        myQueue.enque(4);
        System.out.println(myQueue.deque());
    }
}

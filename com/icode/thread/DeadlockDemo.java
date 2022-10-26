package com.icode.thread;

public class DeadlockDemo {

    public static void main(String[] args) {
        String res1 = "Resource1";
        String res2 = "Resource2";

        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (res1) {
                    System.out.println("Thread1 : Locked resource 1");

                    synchronized (res2) {
                        System.out.println("Thread1 : Locked resource 2");
                    }
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized (res2) {
                    System.out.println("Thread2 : Locked resource 2");

                    synchronized (res1) {
                        System.out.println("Thread2 : Locked resource 1");
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }
}

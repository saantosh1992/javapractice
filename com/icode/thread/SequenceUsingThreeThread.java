package com.icode.thread;

class SequenceThread implements Runnable {

    public int maxNum = 10;
    private int remainder;
    static int num = 1;
    static Object lock = new Object();

    public SequenceThread(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {

        while (num < maxNum -1) {
            synchronized (lock) {
                while(num % 3 != remainder) {
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+":"+num);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                num++;
                lock.notifyAll();
            }
        }
    }
}

public class SequenceUsingThreeThread {

    public static void main(String[] args) {
        SequenceThread s1 = new SequenceThread(1);
        SequenceThread s2 = new SequenceThread(2);
        SequenceThread s3 = new SequenceThread(0);
        Thread thread1 = new Thread(s1);
        Thread thread2 = new Thread(s2);
        Thread thread3 = new Thread(s3);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

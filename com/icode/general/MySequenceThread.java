package com.icode.general;

public class SequenceThread implements Runnable {


    int max = 10;
    static int count = 1;
    int remainder;

    static Object lock = new Object();
    public SequenceThread(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {

        synchronized (lock) {

            while (count <= max) {

                if (count % 3 != remainder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Thread:"+Thread.currentThread().getName()+"value:"+count);
                count++;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {

        new Thread(new SequenceThread(1)).start();
        new Thread(new SequenceThread(2)).start();
        new Thread(new SequenceThread(0)).start();
    }
}


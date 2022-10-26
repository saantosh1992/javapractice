package com.icode.array;


class PrintSequence implements Runnable {

    static int count = 1;
    int max = 10;
    private static Object lock = new Object();
    int remainder;

    public PrintSequence(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {

        while(count <= max) {
            synchronized (lock) {

                while(count % 3 != remainder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println(Thread.currentThread().getName()+":" + count);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count++;
                lock.notifyAll();

            }
        }
    }
}

public class PrintSequenceInThread {

    public static void main(String[] args) {

        PrintSequence seq1 = new PrintSequence(1);
        PrintSequence seq2 = new PrintSequence(2);
        PrintSequence seq3 = new PrintSequence(0);

        Thread t1 = new Thread(seq1);
        Thread t2 = new Thread(seq2);
        Thread t3 = new Thread(seq3);
        t1.start();
        t2.start();
        t3.start();
    }
}

package com.icode.thread;

class Thread1 implements Runnable {

    Thread thread;

    public Thread1() {
        thread = new Thread(this);
    }

    @Override
    public void run() {

        System.out.println("In thread");
        while (!thread.isInterrupted()) {
            System.out.println("Thread is running...");
        }
        System.out.println("Thread is stopped..");
    }

    public void stopThread() {
        thread.interrupt();
    }
}

public class StopThreadUsingInterrupt {
    public static void main(String[] args) throws InterruptedException {

        Thread1 thread1 = new Thread1();
        //Thread thread = new Thread(thread1);
        System.out.println("Starting the thread...");
        thread1.thread.start();
        Thread.sleep(1000);
        System.out.println("Stopping the thread..");
        thread1.stopThread();
    }
}

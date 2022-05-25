package com.icode.thread;

class MyThread implements Runnable {

    private volatile boolean isStop = false;
    @Override
    public void run() {

        while(!isStop) {
            System.out.println("Thread is running..");
        }
        System.out.println("Thread is stopped..");
    }

    public void stopThread() {
        isStop = true;
    }
}
public class StopThread {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        System.out.println("Starting the thread");
        thread.start();

        System.out.println("Stopping the thread");
        myThread.stopThread();
    }

}

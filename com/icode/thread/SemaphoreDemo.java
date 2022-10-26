package com.icode.thread;

import java.util.concurrent.Semaphore;

class SharedResource {

     static int count = 0;
}

class SemaPhoreThread extends Thread {
    Semaphore semaphore;
    String threadName;
    public SemaPhoreThread(Semaphore semaphore, String threadName) {
        super(threadName);
        this.semaphore = semaphore;
        this.threadName = threadName;
    }

    @Override
    public void run() {

        if (this.threadName.equals("A")) {
            System.out.println("Starting the thread:"+"A");
            try {
                semaphore.acquire();
                for (int i = 0; i < 5; i++) {
                    SharedResource.count++;
                    System.out.println("Counter:"+SharedResource.count);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        } else if (this.threadName.equals("B")) {
            System.out.println("Starting thread: B");
            try {
                semaphore.acquire();
                for(int i = 0; i < 5; i++) {
                    SharedResource.count--;
                    System.out.println("Counter:"+SharedResource.count);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }
}

public class SemaphoreDemo {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        SemaPhoreThread thread1 = new SemaPhoreThread(semaphore, "A");
        SemaPhoreThread thread2 = new SemaPhoreThread(semaphore, "B");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

}

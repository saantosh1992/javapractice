package com.icode.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

class Worker extends Thread {
    int name;
    int delay;
    CountDownLatch countDownLatch;

    public Worker(String name, int delay, CountDownLatch countDownLatch) {
        super(name);
        this.delay = delay;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName()+ " finished...");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(3);


        Worker worker1 = new Worker("Worker1", 1000, countDownLatch);
        Worker worker2 = new Worker("Worker2", 2000, countDownLatch);
        Worker worker3 = new Worker("Worker3", 4000, countDownLatch);

        worker1.start();
        worker2.start();
        worker3.start();
        countDownLatch.await();
        System.out.println("All thread finished, start working...");
    }

}

package com.icode.thread.producer;

import java.util.List;

public class Producer implements Runnable {

    private List<Integer> taskQueue;
    private int maxSize;

    public Producer(List<Integer> taskQueue, int maxSize) {
        this.taskQueue = taskQueue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        int counter = 0;

        while(true) {
            try {
                produce(counter++);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void produce(int i) throws InterruptedException {

        synchronized (taskQueue) {

            while(taskQueue.size() == maxSize) {
                System.out.println("The Queue is full"+Thread.currentThread().getName()+"is waiting size:"+taskQueue.size());
                taskQueue.wait();
            }
            Thread.sleep(1000);
            taskQueue.add(i);
            System.out.println("Produced:"+i);
            taskQueue.notifyAll();

        }
    }
}

package com.icode.thread.producer;

import java.util.List;

public class Consumer implements Runnable {

    private List<Integer> taskQueue;

    public Consumer(List<Integer> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                consume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException {

        synchronized (taskQueue) {
            while(taskQueue.isEmpty()) {
                System.out.println("Queue is empty:"+Thread.currentThread().getName()+" is waiting, size:"+taskQueue.size());
                taskQueue.wait();
            }
            Thread.sleep(1000);
            int val = taskQueue.remove(0);
            System.out.println("Consumed:"+val);
            taskQueue.notifyAll();
        }
    }
}

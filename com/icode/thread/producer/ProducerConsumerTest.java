package com.icode.thread.producer;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerTest {

    public static void main(String[] args) {

        List<Integer> taskQueue = new ArrayList<>();
        int maxSize = 5;
        Producer producer = new Producer(taskQueue, maxSize);
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(new Consumer(taskQueue));
        producerThread.start();
        consumerThread.start();

    }
}

package com.hackerrank.java;

import java.util.Random;

public class ProducerConsumerProblem {
    public static void main(String[] args) {
        Drop drop = new Drop();
        new Thread(new Producer(drop)).start();
        new Thread(new Consumer(drop)).start();
    }
}

class Drop {
    private String message;
    private boolean flag = true;

    synchronized String take() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = true;
        notifyAll();
        return message;
    }

    public synchronized void put(String message) {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = false;
        this.message = message;
        notifyAll();
    }
}

class Producer implements Runnable {

    private Drop drop;

    Producer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        String[] importantInfo = {"Mares eat oats", "Does eat oats",
                "Little lambs eat ivy", "A kid will eat ivy too"};
        Random random = new Random();
        for (String s : importantInfo) {
            drop.put(s);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        drop.put("Done!");
    }
}

class Consumer implements Runnable {

    private Drop drop;

    Consumer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        Random random = new Random();
        for (String message = drop.take(); !message.equals("Drop!"); message = drop
                .take()) {
            System.out.println(message);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
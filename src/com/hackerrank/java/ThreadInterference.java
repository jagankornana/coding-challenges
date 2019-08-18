package com.hackerrank.java;

public class ThreadInterference {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        System.out.println("Counter value: " + counter.value());
        Thread t1 = new Thread(new MyThread(counter));
        Thread t2 = new Thread(new MyThread(counter));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Counter value: " + counter.value());
    }
}

class MyThread implements Runnable {
    private Counter counter;

    MyThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " in run method");
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            counter.increment();
            counter.decrement();
        }
    }
}

class Counter {
    private int count = 0;

    synchronized void increment() {
        System.out.println(Thread.currentThread().getName()
                + " in increment method");
        count++;
    }

    synchronized void decrement() {
        System.out.println(Thread.currentThread().getName()
                + " in decrement method");
        count--;
    }

    synchronized int value() {
        System.out.println(Thread.currentThread().getName()
                + " in value method");
        return count;
    }
}
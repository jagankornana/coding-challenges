package com.algorithms;

public class Queue {

    private int[] queue;
    private int front = 0;
    private int rear = -1;
    private int capacity;
    private int currentSize = 0;

    Queue(int capacity) {
        queue = new int[capacity];
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue(10);
        q.enqueue(20);
        System.out.println(q.dequeue());
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }

    void enqueue(int element) {
        if (isQueueFull()) {
            System.out.println("Queue is full.");
        } else {
            rear++;
            if (rear == capacity)
                rear = 0;
            queue[rear] = element;
            currentSize++;
        }
    }

    int dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        } else {
            if (front == capacity)
                front = 0;
            int value = queue[front];
            front++;
            currentSize--;
            return value;
        }
    }

    private boolean isQueueFull() {
        return currentSize == capacity;
    }

    boolean isQueueEmpty() {
        return currentSize == 0;
    }
}

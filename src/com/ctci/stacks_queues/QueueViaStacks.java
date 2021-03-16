package com.ctci.stacks_queues;

public class QueueViaStacks {

    public static void main(String[] args) throws Exception {
        MyQueue queue = new MyQueue(10);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }

    static class MyQueue {
        int capacity;
        Stack firstStack;
        Stack secondStack;

        MyQueue(int capacity) {
            this.capacity = capacity;
            firstStack = new Stack(capacity / 2);
            secondStack = new Stack(capacity / 2);
        }

        void add(int element) {
            if (!firstStack.isFull()) {
                firstStack.push(element);
            } else {
                System.out.println("Queue is Full");
            }
        }

        int remove() throws Exception {
            if (secondStack.isEmpty()) {
                moveElements();
                return secondStack.pop();
            } else {
                return secondStack.pop();
            }
        }

        private void moveElements() throws Exception {
            if (firstStack.isEmpty()) {
                throw new Exception("Queue is empty");
            }
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }

    }

    static class Stack {
        int capacity;
        int size = 0;
        int[] array;

        Stack(int capacity) {
            this.capacity = capacity;
            array = new int[capacity];
        }

        void push(int element) {
            array[size++] = element;
        }

        int pop() {
            return array[--size];
        }

        boolean isEmpty() {
            return size == 0;
        }

        boolean isFull() {
            return capacity == size;
        }

    }
}

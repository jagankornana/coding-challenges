package com.ctci.stacks_queues;

public class QueueUsingArray {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(3);
        try {
            queue.add(1);
            queue.add(2);
            queue.add(3);
            System.out.println(queue.remove());
            queue.add(4);
            System.out.println(queue.remove());
            System.out.println(queue.remove());
            queue.add(5);
            System.out.println(queue.remove());
            System.out.println(queue.remove());
            queue.add(6);
            queue.add(7);
            queue.add(8);
            System.out.println(queue.peek());
            System.out.println(queue.isEmpty());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    static class Queue<E> {
        E[] array;
        int front;
        int rear;
        int count;

        @SuppressWarnings("unchecked")
        Queue(int size) {
            array = (E[]) new Object[size];
            front = 0;
            rear = 0;
            count = 0;
        }

        void add(E element) throws Exception {
            if (count == array.length) {
                throw new Exception("Queue overflow");
            }
            if (rear == array.length && count < array.length) {
                rear = 0;
            }
            array[rear++] = element;
            count++;
        }

        E remove() throws Exception {
            if (isEmpty()) {
                throw new Exception("Queue underflow");
            }
            E element = array[front++];
            count--;
            if (front == array.length) {
                front = 0;
            }
            return element;
        }

        E peek() throws Exception {
            if (isEmpty()) {
                throw new Exception("Queue underflow");
            }
            return array[front];
        }

        private boolean isEmpty() {
            return count == 0;
        }
    }
}

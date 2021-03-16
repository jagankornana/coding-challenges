package com.ctci.stacks_queues;

public class QueueUsingLinkedList {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
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
        private Node front;
        private Node rear;

        void add(E element) {
            Node node = new Node(element);
            if (rear == null) {
                rear = node;
                front = node;
            } else {
                rear.next = node;
                rear = node;
            }
        }

        E remove() throws Exception {
            if (isEmpty()) {
                throw new Exception("Queue underflow");
            }
            E element = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return element;
        }

        E peek() throws Exception {
            if (isEmpty()) {
                throw new Exception("Queue underflow");
            }
            return front.data;
        }

        private boolean isEmpty() {
            return front == null;
        }

        private class Node {
            E data;
            Node next = null;

            Node(E data) {
                this.data = data;
            }
        }
    }
}

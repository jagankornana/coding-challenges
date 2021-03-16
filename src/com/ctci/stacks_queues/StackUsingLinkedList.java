package com.ctci.stacks_queues;

public class StackUsingLinkedList {

    public static void main(String[] args) {
        Stack<String> books = new Stack<>();
        for (int i = 0; i < 6; i++) {
            books.push("Book_" + i);
        }

        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(books.pop());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        try {
            System.out.println(books.peek());
            System.out.println(books.pop());
            System.out.println(books.isEmpty());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    static class Stack<E> {
        Node top;

        void push(E element) {
            Node node = new Node(element);
            if (top == null) {
                top = node;
            } else {
                node.next = top;
                top = node;
            }
        }

        E pop() throws Exception {
            if (isEmpty()) {
                throw new Exception("Stack underflow");
            }
            E element = top.data;
            top = top.next;
            return element;
        }

        E peek() throws Exception {
            if (isEmpty()) {
                throw new Exception("Stack underflow");
            }
            return top.data;
        }

        private boolean isEmpty() {
            return top == null;
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

package com.ctci.stacks_queues;

public class StackUsingArray {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>(5);
        for (int i = 1; i <= 5; i++) {
            try {
                stack.push("Book_" + i);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("Elements in stack:");
        while (!stack.isEmpty()) {
            try {
                System.out.println(stack.pop());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    static class Stack<E> {
        int size;
        E[] array;

        @SuppressWarnings("unchecked")
        Stack(int size) {
            array = (E[]) new Object[size];
            this.size = -1;
        }

        void push(E element) throws Exception {
            if (size == array.length - 1) {
                throw new Exception("Stack overflow");
            }
            array[++size] = element;
        }

        E pop() throws Exception {
            if (isEmpty()) {
                throw new Exception("Stack underflow");
            }
            return array[size--];
        }

        E peek() throws Exception {
            if (isEmpty()) {
                throw new Exception("Stack empty");
            }
            return array[size];
        }

        boolean isEmpty() {
            return size == -1;
        }
    }
}

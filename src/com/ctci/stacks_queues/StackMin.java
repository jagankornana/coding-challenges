package com.ctci.stacks_queues;

public class StackMin {

    public static void main(String[] args) throws Exception {
        Stack stack = new Stack(5);
        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(4);
        System.out.println(stack.min());
        System.out.println(stack.pop());
        System.out.println(stack.min());
        System.out.println(stack.pop());
        System.out.println(stack.min());
    }

    private static class Stack {
        int size;
        int top = -1;
        int min = Integer.MAX_VALUE;
        int[] array;
        int[] track;

        Stack(int size) {
            this.size = size;
            array = new int[size];
            track = new int[size];
        }

        void push(int element) throws Exception {
            if (isFull()) {
                throw new Exception("Stack is full");
            }
            array[++top] = element;
            if (element < min) {
                min = element;
                track[top] = min;
            } else {
                track[top] = min;
            }
        }

        int pop() throws Exception {
            if (isEmpty()) {
                throw new Exception("Stack is empty");
            }
            return array[top--];

        }

        int min() {
            return track[top];
        }

        private boolean isEmpty() {
            return top == -1;
        }

        private boolean isFull() {
            return top == (size - 1);
        }
    }
}

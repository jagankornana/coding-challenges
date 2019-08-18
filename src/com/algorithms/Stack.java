package com.algorithms;

public class Stack {

    private int[] stack;
    private int top = -1;
    private int size;

    public Stack(int size) {
        stack = new int[size];
        this.size = size;
    }

    public static void main(String[] args) {
        Stack s = new Stack(5);
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("Size " + s.size());
        s.pop();
        System.out.println("Peek " + s.top());
        s.push(4);
        s.push(5);
        s.push(6);
        System.out.println("Size " + s.size());
        s.push(7);

    }

    public int push(int element) {
        if (top == size - 1) {
            System.out.println("Stack is overflow");
            return -1;
        } else {
            top++;
            stack[top] = element;
            return 1;
        }
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack is underflow.");
        } else {
            top--;
        }
    }

    int top() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return -1;
        } else {
            return stack[top];
        }
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

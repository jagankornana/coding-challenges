package com.ctci.stacks_queues;

import java.util.ArrayList;
import java.util.List;

public class StackOfPlates {

    public static void main(String[] args) {
        SetOfStacks setOfStacks = new SetOfStacks(3);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);
        setOfStacks.push(6);
        setOfStacks.push(7);
        setOfStacks.push(8);

        System.out.println(setOfStacks.popAt(0));
        setOfStacks.displayStackElements(1);
        setOfStacks.displayStackElements(2);
    }

    static class SetOfStacks {
        int threshold;
        List<Stack> stacks = new ArrayList<>();

        SetOfStacks(int threshold) {
            this.threshold = threshold;
        }

        void push(int element) {
            Stack last = getLastStack();
            if (last != null && !last.isFull()) {
                last.push(element);
            } else {
                Stack stack = new Stack(threshold);
                stack.push(element);
                stacks.add(stack);
            }
        }

        int pop() throws Exception {
            Stack last = getLastStack();
            int element;
            if (last == null) {
                throw new Exception("Stack is empty");
            } else {
                element = last.pop();
            }
            if (last.isEmpty()) {
                stacks.remove(stacks.size() - 1);
            }
            return element;
        }

        int popAt(int index) {
            return leftShift(index, true);
        }

        private Stack getLastStack() {
            if (stacks.size() == 0) {
                return null;
            } else {
                return stacks.get(stacks.size() - 1);
            }
        }

        private int leftShift(int index, boolean removeTop) {
            Stack stack = stacks.get(index);
            int removedElement;
            if (removeTop) {
                removedElement = stack.pop();
            } else {
                removedElement = stack.removeBottom();
            }
            if (stack.isEmpty()) {
                stacks.remove(index);
            } else if (stacks.size() > index + 1) {
                int element = leftShift(index + 1, false);
                stack.push(element);
            }
            return removedElement;
        }

        void displayStackElements(int index) {
            Stack stack = stacks.get(index);
            Stack.Node node = stack.top;
            while (node != null) {
                System.out.print(node.data + " ");
                node = node.prev;
            }
            System.out.println();
        }
    }

    static class Stack {

        int capacity;
        int size = 0;
        Node top, bottom;

        Stack(int capacity) {
            this.capacity = capacity;
        }

        void push(int element) {
            Node node = new Node(element);
            if (top == null) {
                top = node;
                bottom = node;
            } else {
                top.next = node;
                node.prev = top;
                top = node;
            }
            size++;
        }

        int pop() {
            int element = top.data;
            top = top.prev;
            size--;
            if (top != null) {
                top.next = null;
            }
            return element;
        }

        int removeBottom() {
            int element = bottom.data;
            bottom = bottom.next;
            size--;
            if (bottom != null) {
                bottom.prev = null;
            }
            return element;
        }

        boolean isEmpty() {
            return size == 0;
        }

        boolean isFull() {
            return size == capacity;
        }

        class Node {
            int data;
            Node next = null;
            Node prev = null;

            Node(int data) {
                this.data = data;
            }
        }
    }
}

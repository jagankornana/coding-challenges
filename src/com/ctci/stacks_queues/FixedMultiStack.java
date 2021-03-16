package com.ctci.stacks_queues;

public class FixedMultiStack {

    private int numOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numOfStacks];
        sizes = new int[numOfStacks];
    }

    public static void main(String[] args) throws Exception {
        FixedMultiStack multiStack = new FixedMultiStack(5);
        multiStack.push(0, 1);
        multiStack.push(0, 2);

        multiStack.push(1, 6);
        multiStack.push(1, 7);

        multiStack.push(2, 11);
        multiStack.push(2, 12);
        multiStack.push(2, 13);
        multiStack.push(2, 14);
        multiStack.push(2, 15);

        System.out.println(multiStack.pop(0));
        System.out.println(multiStack.pop(0));

        System.out.println(multiStack.pop(1));
        System.out.println(multiStack.pop(1));

        System.out.println(multiStack.pop(2));
        System.out.println(multiStack.pop(2));
        System.out.println(multiStack.pop(2));
        System.out.println(multiStack.pop(2));
        System.out.println(multiStack.pop(2));
    }

    public void push(int stackNum, int value) throws Exception {
        if (isFull(stackNum)) {
            throw new Exception("Stack is full");
        }
        int index = stackNum * stackCapacity + sizes[stackNum];
        values[index] = value;
        sizes[stackNum]++;
    }

    public int peek(int stackNum) {
        int index = stackNum * stackCapacity + sizes[stackNum];
        return values[index];
    }

    public int pop(int stackNum) throws Exception {
        if (isEmpty(stackNum)) {
            throw new Exception("Stack is empty");
        }
        sizes[stackNum]--;
        int index = stackNum * stackCapacity + sizes[stackNum];
        return values[index];
    }

    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    private boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }
}

package com.algorithms;

public class PriorityQueue {

    public static int length = 0;

    private static void maxHeapify(int[] priorityQueue, int i) {
        int leftChild = i * 2;
        int rightChild = i * 2 + 1;
        int largest;
        if (leftChild <= length && priorityQueue[leftChild] > priorityQueue[i]) {
            largest = leftChild;
        } else {
            largest = i;

        }
        if (rightChild <= length && priorityQueue[rightChild] > priorityQueue[largest]) {
            largest = rightChild;
        }
        if (largest != i) {
            int temp = priorityQueue[i];
            priorityQueue[i] = priorityQueue[largest];
            priorityQueue[largest] = temp;
            maxHeapify(priorityQueue, largest);
        }
    }

    private static int maximum(int[] priorityQueue) {
        return priorityQueue[1];
    }

    private static int extractMaximum(int[] priorityQueue) {
        if (length == 0) {
            System.out.println("Priority queue is empty.");
        }
        int max = priorityQueue[1];
        priorityQueue[1] = priorityQueue[length];
        length--;
        maxHeapify(priorityQueue, 1);
        return max;
    }

    private static void increaseValue(int[] priorityQueue, int i, int value) {
        if (value < priorityQueue[i]) {
            System.out.println("value is less the current value, can't be inserted.");
        } else {
            priorityQueue[i] = value;
            while (i > 1 && priorityQueue[i / 2] < priorityQueue[i]) {
                int temp = priorityQueue[i];
                priorityQueue[i] = priorityQueue[i / 2];
                priorityQueue[i / 2] = temp;
                i /= 2;
            }
        }
    }

    private static void insertValue(int[] priorityQueue, int value) {
        length = length + 1;
        priorityQueue[length] = -1;
        increaseValue(priorityQueue, length, value);
    }

    public static void main(String[] args) throws NumberFormatException {
        int[] priorityQueue = new int[10];
        insertValue(priorityQueue, 1);
        insertValue(priorityQueue, 8);
        insertValue(priorityQueue, 5);
        insertValue(priorityQueue, 3);
        for (int i = 1; i <= length; i++) {
            System.out.print(priorityQueue[i] + " ");
        }
        System.out.println();
        System.out.println(maximum(priorityQueue));
        System.out.println(extractMaximum(priorityQueue));
        for (int i = 1; i <= length; i++) {
            System.out.print(priorityQueue[i] + " ");
        }
    }
}

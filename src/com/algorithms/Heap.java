package com.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Heap {

    private static int[] heapArray;

    private static void maxHeapify(int i, int n) {
        int leftChild = i * 2;
        int rightChild = i * 2 + 1;
        int largest;
        if (leftChild <= n && heapArray[leftChild] > heapArray[i]) {
            largest = leftChild;
        } else {
            largest = i;

        }
        if (rightChild <= n && heapArray[rightChild] > heapArray[largest]) {
            largest = rightChild;
        }
        if (largest != i) {
            int temp = heapArray[i];
            heapArray[i] = heapArray[largest];
            heapArray[largest] = temp;
            maxHeapify(largest, n);
        }
    }

    private static void buildMaxHeap(int n) {
        for (int i = n / 2; i >= 1; i--) {
            maxHeapify(i, n);
        }
    }

    private static void minHeapify(int i, int n) {
        int leftChild = i * 2;
        int rightChild = i * 2 + 1;
        int smallest;
        if (leftChild <= n && heapArray[leftChild] < heapArray[i])
            smallest = leftChild;
        else
            smallest = i;
        if (rightChild <= n && heapArray[rightChild] < heapArray[smallest])
            smallest = rightChild;
        if (smallest != i) {
            int temp = heapArray[i];
            heapArray[i] = heapArray[smallest];
            heapArray[smallest] = temp;
            minHeapify(smallest, n);
        }
    }

    public static void buildMinHeap(int n) {
        for (int i = n / 2; i >= 1; i--) {
            minHeapify(i, n);
        }
    }

    private static void heapSort(int n) {
        buildMaxHeap(n);
        for (int i = n; i >= 2; i--) {
            int temp = heapArray[1];
            heapArray[1] = heapArray[i];
            heapArray[i] = temp;
            maxHeapify(1, --n);
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        heapArray = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            heapArray[i] = Integer.parseInt(br.readLine());
        }

        // buildMaxHeap(n);
        // System.out.println();
        // buildMinHeap(n);
        // System.out.println();

        heapSort(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(heapArray[i] + " ");
        }
    }
}

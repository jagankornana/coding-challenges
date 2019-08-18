package com.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {

    public static int[] array;

    private static void mergeSort(int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(p, q);
            mergeSort(q + 1, r);
            merge(p, q, r);
        }
    }

    private static void merge(int p, int q, int r) {
        int leftArrSize = q - p + 1;
        int rightArrSize = r - q;
        int[] leftArray = new int[leftArrSize];
        int[] rightArray = new int[rightArrSize];

        for (int i = 0; i < leftArrSize; i++) {
            leftArray[i] = array[p + i];
        }

        for (int i = 0; i < rightArrSize; i++) {
            rightArray[i] = array[q + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = p;
        while (i < leftArrSize && j < rightArrSize) {
            if (leftArray[i] <= rightArray[j])
                array[k++] = leftArray[i++];
            else
                array[k++] = rightArray[j++];
        }
        while (i < leftArrSize)
            array[k++] = leftArray[i++];
        while (j < rightArrSize)
            array[k++] = rightArray[j++];
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

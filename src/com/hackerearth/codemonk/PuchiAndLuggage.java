package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PuchiAndLuggage {

    public static int[] sortedArray;

    public static void mergeSort(int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(p, q);
            mergeSort(q + 1, r);
            merge(p, q, r);
        }
    }

    public static void merge(int p, int q, int r) {
        int leftArrSize = q - p + 1;
        int rightArrSize = r - q;
        int[] leftArray = new int[leftArrSize];
        int[] rightArray = new int[rightArrSize];

        for (int i = 0; i < leftArrSize; i++) {
            leftArray[i] = sortedArray[p + i];
        }

        for (int i = 0; i < rightArrSize; i++) {
            rightArray[i] = sortedArray[q + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = p;
        while (i < leftArrSize && j < rightArrSize) {
            if (leftArray[i] <= rightArray[j])
                sortedArray[k++] = leftArray[i++];
            else
                sortedArray[k++] = rightArray[j++];
        }
        while (i < leftArrSize)
            sortedArray[k++] = leftArray[i++];
        while (j < rightArrSize)
            sortedArray[k++] = rightArray[j++];
    }

    public static void main(String[] args) throws NumberFormatException,
            IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sortedArray = new int[n];
            int[] inputArray = new int[n];
            for (int j = 0; j < n; j++) {
                inputArray[j] = Integer.parseInt(br.readLine());
                sortedArray[j] = inputArray[j];
            }

            mergeSort(0, n - 1);

            for (int x = 0; x < n; x++) {
                int num = inputArray[x];
                int count = 0;
                int y = 0;
                for (; sortedArray[y] < num; y++) {
                    if (sortedArray[y] != 0)
                        count++;
                }
                sortedArray[y] = 0;
                System.out.print(count + " ");
            }
            System.out.println();
        }
    }

}

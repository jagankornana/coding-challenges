package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChanduAndHisGirlfriend {

    private static long[] sortedArray;

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
        long[] leftArray = new long[leftArrSize];
        long[] rightArray = new long[rightArrSize];

        System.arraycopy(sortedArray, p, leftArray, 0, leftArrSize);

        for (int i = 0; i < rightArrSize; i++) {
            rightArray[i] = sortedArray[q + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = p;
        while (i < leftArrSize && j < rightArrSize) {
            if (leftArray[i] >= rightArray[j])
                sortedArray[k++] = leftArray[i++];
            else
                sortedArray[k++] = rightArray[j++];
        }
        while (i < leftArrSize)
            sortedArray[k++] = leftArray[i++];
        while (j < rightArrSize)
            sortedArray[k++] = rightArray[j++];
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            sortedArray = new long[n];
            st = new StringTokenizer(input, " ");
            for (int j = 0; j < n; j++) {
                sortedArray[j] = Long.parseLong(st.nextToken());
            }

            mergeSort(0, n - 1);

            for (int j = 0; j < n; j++)
                System.out.print(sortedArray[j] + " ");
            System.out.println();
        }
    }
}


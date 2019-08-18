package com.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {

    public static int[] array;

    private static void quickSort(int low, int high) {
        if (low < high) {
            int mid = partition(low, high);
            quickSort(low, mid - 1);
            quickSort(mid + 1, high);

        }
    }

    private static int partition(int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        int j = low;
        for (; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) throws NumberFormatException,
            IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        quickSort(0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        br.close();
    }
}

package com.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSort {
    public static void main(String[] args) throws NumberFormatException,
            IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++)
            System.out.print(array[i] + " ");
    }
}

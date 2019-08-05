package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MonkInTheGrassFields {

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] poisonArray = new int[n][n];
            for (int p = 0; p < n; p++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int q = 0; q < n; q++) {
                    poisonArray[p][q] = Integer.parseInt(st.nextToken());
                }
            }
            int[] rowSumArray = new int[n];
            int[] colSumArray = new int[n];
            for (int p = 0; p < n; p++) {
                for (int q = 0; q < n; q++) {
                    rowSumArray[p] += poisonArray[p][q];
                    colSumArray[p] += poisonArray[q][p];
                }
            }

            insertionSort(rowSumArray);
            insertionSort(colSumArray);

            long[] usingRows = new long[k + 1];
            long[] usingCols = new long[k + 1];
            usingRows[0] = 0;
            usingCols[0] = 0;

            for (int j = 1; j <= k; j++) {
                long rowMin = rowSumArray[0];
                long colMin = colSumArray[0];
                usingRows[j] = usingRows[j - 1] + rowMin;
                usingCols[j] = usingCols[j - 1] + colMin;
                rowSumArray[0] += n;
                colSumArray[0] += n;
                insertionSort(rowSumArray);
                insertionSort(colSumArray);
            }

            long minDiscomfort = 1000000000;
            for (int j = 0; j <= k; j++)
                minDiscomfort = Math.min(minDiscomfort, usingRows[j] + usingCols[k - j] + j * (k - j));
            System.out.println(minDiscomfort);
        }
    }
}


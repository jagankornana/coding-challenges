package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MonkAndMultiplication {

    private static void insertValue(int[] priorityQueue, int index, int value) {
        priorityQueue[index] = value;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] priorityQueue = new int[4];
        Arrays.fill(priorityQueue, -1);
        for (int i = 1; i <= n; i++) {
            int value = Integer.parseInt(st.nextToken());

            if (i == 1 || i == 2 || i == 3) {
                insertValue(priorityQueue, i, value);
            } else if (value > priorityQueue[1]) {
                insertValue(priorityQueue, 1, value);
            }
            if (i == 1 || i == 2) {
                System.out.println("-1");
            } else {
                int a = priorityQueue[1];
                int b = priorityQueue[2];
                int c = priorityQueue[3];
                System.out.println(a * b * c);
                Arrays.sort(priorityQueue);
            }
        }
    }
}

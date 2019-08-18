package com.hackerrank.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HourGlass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] numArray = new int[6][6];
        StringTokenizer st;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 6; j++) {
                numArray[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int maxSum = 0;
        int sum;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sum = numArray[i][j] + numArray[i][j + 1] + numArray[i][j + 2] + numArray[i + 1][j + 1] + numArray[i + 2][j] + numArray[i + 2][j + 1] + numArray[i + 2][j + 2];
                if (i == 0 && j == 0)
                    maxSum = sum;
                else if (sum > maxSum)
                    maxSum = sum;
            }
        }
        System.out.println(maxSum);
    }
}
package com.hackerrank.problems;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, primeDiagonalSum = 0, secondDiagonalSum = 0;
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        // prime diagonal sum
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    primeDiagonalSum += arr[i][j];
                }
            }
        }
        // second diagonal sum
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + j == n - 1) {
                    secondDiagonalSum += arr[i][j];
                }
            }
        }
        System.out.println(primeDiagonalSum + " " + secondDiagonalSum);
        // absolute diagonal difference
        System.out.println(Math.abs(primeDiagonalSum - secondDiagonalSum));
        sc.close();
    }
}

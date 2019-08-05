package com.hackerearth.codemonk;

import java.util.Arrays;

public class WinesProblemDP {

    private static int n = 5;
    private static int[] prices = {2, 3, 5, 1, 4};
    private static int[][] cache = new int[n][n];

    private static int profitBackTracking(int begin, int end) {
        if (begin > end) {
            return 0;
        }
        int year = n - (end - begin + 1) + 1;

        return Math.max(profitBackTracking(begin + 1, end) + prices[begin] * year,
                profitBackTracking(begin, end - 1) + prices[end] * year);
    }

    private static int profitDynamicProgramming(int begin, int end) {
        if (begin > end) {
            return 0;
        }
        int year = n - (end - begin + 1) + 1;

        if (cache[begin][end] != -1) {
            return cache[begin][end];
        }
        return cache[begin][end] = Math.max(profitDynamicProgramming(begin + 1, end) + prices[begin] * year,
                profitDynamicProgramming(begin, end - 1) + prices[end] * year);
    }

    public static void main(String[] args) {
        System.out.println(profitBackTracking(0, n - 1));
        for (int[] arr : cache) {
            Arrays.fill(arr, -1);
        }
        System.out.println(profitDynamicProgramming(0, n - 1));
    }
}
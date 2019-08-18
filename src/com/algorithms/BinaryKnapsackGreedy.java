package com.algorithms;

public class BinaryKnapsackGreedy {

    private static int knapsackRecursive(int[] val, int[] wt, int w, int n) {
        if (n == 0 || w == 0)
            return 0;
        else if (wt[n - 1] > w)
            return knapsackRecursive(val, wt, w, n - 1);
        else
            return Math.max((val[n - 1] + knapsackRecursive(val, wt, w - wt[n - 1], n - 1)),
                    knapsackRecursive(val, wt, w, n - 1));
    }

    public static void main(String[] args) {
        int[] val = {100, 120, 60};
        int[] wt = {20, 30, 10};
        int w = 50;
        int n = val.length;
        System.out.println(knapsackRecursive(val, wt, w, n));
    }
}

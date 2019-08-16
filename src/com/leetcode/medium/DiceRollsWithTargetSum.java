package com.leetcode.medium;

import java.util.Arrays;

public class DiceRollsWithTargetSum {

    private static int[][] memory;

    public static void main(String[] args) {
        DiceRollsWithTargetSum targetSum = new DiceRollsWithTargetSum();
        System.out.println(targetSum.numRollsToTarget(1, 6, 3));
        System.out.println(targetSum.numRollsToTarget(2, 6, 7));
        System.out.println(targetSum.numRollsToTarget(2, 5, 10));
        System.out.println(targetSum.numRollsToTarget(1, 2, 3));
        System.out.println(targetSum.numRollsToTarget(30, 30, 500));
    }

    private int numRollsToTarget(int d, int f, int target) {
        memory = new int[d + 1][target + 1];
        for (int[] arr : memory) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        return rollDice(d, f, target);
    }

    private int rollDice(int d, int f, int target) {
        if (d == 1) {
            if (target <= f) {
                return 1;
            } else {
                return 0;
            }
        }
        int count = 0;
        for (int i = 1; i <= f; i++) {
            if (target - i > 0) {
                if (memory[d - 1][target - i] != Integer.MAX_VALUE) {
                    count += memory[d - 1][target - i];
                    count %= 1000000007;
                } else {
                    count += rollDice(d - 1, f, target - i);
                    memory[d - 1][target - i] = count % 1000000007;
                }
            }
        }
        return count;
    }
}

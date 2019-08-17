package com.leetcode.medium;

public class DiceRollsWithTargetSum {

    private int prime = (int) (1e9 + 7);

    public static void main(String[] args) {
        DiceRollsWithTargetSum targetSum = new DiceRollsWithTargetSum();
        System.out.println(targetSum.numRollsToTarget(1, 6, 3));
        System.out.println(targetSum.numRollsToTarget(2, 6, 7));
        System.out.println(targetSum.numRollsToTarget(2, 5, 10));
        System.out.println(targetSum.numRollsToTarget(1, 2, 3));
        System.out.println(targetSum.numRollsToTarget(30, 30, 500));
    }

    private int numRollsToTarget(int d, int f, int target) {
        Integer[][] memory = new Integer[d + 1][target + 1];
        memory[0][0] = 1;
        return rollDice(d, f, target, memory);
    }

    private int rollDice(int d, int f, int target, Integer[][] memory) {
        if (target < 0) return 0;
        if (d == 0 && target > 0) return 0;
        if (memory[d][target] != null) return memory[d][target];
        int count = 0;
        for (int i = 1; i <= f; i++) {
            count += rollDice(d - 1, f, target - i, memory);
            count %= prime;
        }
        memory[d][target] = count;
        return count;
    }
}

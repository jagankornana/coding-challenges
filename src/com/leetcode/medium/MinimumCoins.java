package com.leetcode.medium;


/**
 * Find the minimum number of coins the sum of which is S
 */
public class MinimumCoins {

    public static void main(String[] args) {
        System.out.println(findMinNumOfCoins(new int[]{1, 3, 5}, 11));
        System.out.println(findMinNumOfCoins(new int[]{2, 4, 5, 7}, 25));
    }

    private static int findMinNumOfCoins(int[] coins, int sum) {
        int[] min = new int[sum + 1];
        for (int i = 1; i <= sum; i++) {
            min[i] = Integer.MAX_VALUE - 10;
        }
        min[0] = 0;
        for (int i = 1; i <= sum; i++) {
            for (int coin : coins) {
                if (coin <= i && (min[i - coin] + 1) < min[i]) {
                    min[i] = min[i - coin] + 1;
                }
            }
//            System.out.println("sum: " + i + ", min coins: " + min[i]);
        }

        return min[sum];
    }
}

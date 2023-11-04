package com.poc.practice;

import java.util.Arrays;

public class PrefixSum {

    public static void main(String[] args) {
        PrefixSum prefixSum = new PrefixSum();
        int[] nums = {1, 6, 3, 2, 7, 2};
        int[][] queries = {{0, 3}, {2, 5}, {2, 4}};
        System.out.println(Arrays.toString(prefixSum.answerQueries(nums, queries, 13)));
    }

    public boolean[] answerQueries(int[] nums, int[][] queries, int limit) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];
            int sum = prefix[y] - prefix[x] + nums[x];
            result[i] = sum < limit;
        }

        return result;
    }
}

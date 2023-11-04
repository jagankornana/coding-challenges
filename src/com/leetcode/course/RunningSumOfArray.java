package com.poc.practice;

import java.util.Arrays;

public class RunningSumOfArray {

    public static void main(String[] args) {
        RunningSumOfArray runningSumOfArray = new RunningSumOfArray();
        System.out.println(Arrays.toString(runningSumOfArray.runningSum(new int[]{1, 2, 3, 4})));
    }

    public int[] runningSum(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        return prefix;
    }
}

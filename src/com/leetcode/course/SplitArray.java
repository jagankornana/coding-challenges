package com.leetcode.course;

public class SplitArray {

    public static void main(String[] args) {
        SplitArray splitArray = new SplitArray();
        System.out.println(splitArray.waysToSplitArray(new int[]{2,3,1,0}));
    }

    public int waysToSplitArray(int[] nums) {
        int count = 0;
        long leftSum = 0, totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            if (leftSum >= (totalSum - leftSum)) {
                count++;
            }
        }

        return count;
    }
}

package com.poc.practice;

import java.util.Arrays;

public class SquaresOfSortedArray {

    public static void main(String[] args) {
        SquaresOfSortedArray obj = new SquaresOfSortedArray();
        int[] result = obj.sortedSquares(new int[]{-7, -3, -2, -1});
        System.out.println(Arrays.toString(result));
    }

    public int[] sortedSquares(int[] nums) {
        int[] sorted = new int[nums.length];
        int k = nums.length - 1;
        for (int i = 0, j = nums.length - 1; i <= j; ) {
            if (Math.abs(nums[i]) >= Math.abs(nums[j])) {
                sorted[k--] = nums[i] * nums[i];
                i++;
            } else {
                sorted[k--] = nums[j] * nums[j];
                j--;
            }
        }
        return sorted;
    }
}

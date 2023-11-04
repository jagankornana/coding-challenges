package com.poc.practice;

public class MaximumAverageSubarray {

    public static void main(String[] args) {
        MaximumAverageSubarray maximumAverageSubarray = new MaximumAverageSubarray();
        System.out.println(maximumAverageSubarray.findMaxAverage(new int[]{1, 2, 3, 4, 5}, 2));
    }

    public double findMaxAverage(int[] nums, int k) {
        int left = 0, right = 0, maxSum = 0, sum;
        for (; right < k; right++) {
            maxSum += nums[right];
        }
        sum = maxSum;
        for (; right < nums.length; right++) {
            sum -= nums[left++];
            sum += nums[right];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum / (k * 1.0);
    }
}

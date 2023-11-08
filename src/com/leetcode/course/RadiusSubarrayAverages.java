package com.leetcode.course;

import java.util.Arrays;

public class RadiusSubarrayAverages {

    public static void main(String[] args) {
        RadiusSubarrayAverages radiusSubarrayAverages = new RadiusSubarrayAverages();
        int[] input = {7,4,3,9,1,8,5,2,6};
        int k = 3;
        int[] averages = radiusSubarrayAverages.getAverages(input, k);
        System.out.println(Arrays.toString(averages));
        averages = radiusSubarrayAverages.getAveragesWithSlidingWindow(input, k);
        System.out.println(Arrays.toString(averages));

    }

    public int[] getAverages(int[] nums, int k) {
        long[] prefix = new long[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int[] result = new int[nums.length];
        int radius = 2 * k + 1;
        for (int i = 0; i < nums.length; i++) {
            if (i < k || (nums.length - i) <= k) {
                result[i] = -1;
            } else {
                result[i] = (int) ((prefix[i + k] - prefix[i - k] + nums[i - k]) / radius);
            }
        }

        return result;
    }

    public int[] getAveragesWithSlidingWindow(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = -1;
        }

        int radius = 2 * k + 1;
        if (nums.length < radius) {
            return result;
        }

        long sum = 0;
        for (int i = 0; i < radius; i++) {
            sum += nums[i];
        }

        int i = k;
        result[i++] = (int) (sum / radius);
        for (; i < nums.length - k; i++) {
            sum = sum - nums[i - k - 1] + nums[i + k];
            result[i] = (int) (sum / radius);
        }

        return result;
    }

}

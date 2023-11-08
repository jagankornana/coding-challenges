package com.leetcode.course;

public class SubarrayProduct {

    public static void main(String[] args) {
        SubarrayProduct subarrayProduct = new SubarrayProduct();
        System.out.println(subarrayProduct.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(subarrayProduct.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 3));
        System.out.println(subarrayProduct.numSubarrayProductLessThanK(new int[]{1, 1, 1, 2}, 3));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int left = 0, product = 1, numOfSubarrays = 0;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left++];
            }
            numOfSubarrays += (right - left + 1);
        }

        return numOfSubarrays;
    }
}

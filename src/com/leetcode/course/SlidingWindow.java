package com.leetcode.course;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 7, 4, 2, 1, 1, 5};
        int result = findLongestSubArrayContainsSumLessThanK(nums, 18);
        System.out.println(result);
        int length = findLongestSubStringContainsAtMostSingleZero("000000");
        System.out.println(length);

    }

    private static int findLongestSubStringContainsAtMostSingleZero(String str) {
        char[] bits = str.toCharArray();
        int left = 0, maxLength = 0, zerosCount = 0, windowSize;
        for (int right = 0; right < bits.length; right++) {
            if (bits[right] == '0') {
                zerosCount++;
            }
            while (zerosCount > 1) {
                if (bits[left] == '0') {
                    zerosCount--;
                }
                left++;
            }
            windowSize = right - left + 1;
            maxLength = Math.max(maxLength, windowSize);
        }

        return maxLength;
    }

    private static int findLongestSubArrayContainsSumLessThanK(int[] nums, int k) {
        int left = 0, result = 0, sum = 0, windowSize = 1;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > k) {
                sum -= nums[left++];
            }
            windowSize = right - left + 1;
            result = Math.max(result, windowSize);
        }
        return result;
    }


}

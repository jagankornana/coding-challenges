package com.leetcode.contests;

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {10, 100, 101, 101};
        System.out.println(isMajorityElement(nums, 101));
    }

    private static boolean isMajorityElement(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }
        return count > (nums.length / 2);
    }
}

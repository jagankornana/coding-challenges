package com.leetcode.contest;

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {10, 100, 101, 101};
//        System.out.println(isMajorityElement(nums, 101));
    }

    private boolean isMajorityElement(int[] nums, int target) {
        int n = nums.length;
        int foundIdx = binarySearch(nums, 0, n - 1, target);
        if (foundIdx == -1) {
            return false;
        } else {
            while (foundIdx >= 1 && nums[foundIdx - 1] == target) {
                foundIdx--;
            }
            int lastIdx = foundIdx + n / 2;
            if (lastIdx > n - 1) {
                return false;
            }
            return nums[lastIdx] == target;
        }
    }

    private int binarySearch(int[] arr, int first, int last, int key) {
        int mid = (first + last) / 2;
        while (first <= last) {
            if (arr[mid] < key) {
                first = mid + 1;
            } else if (arr[mid] == key) {
                return mid;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        return -1;
    }
}

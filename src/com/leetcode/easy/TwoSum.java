package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] sol = twoSum.twoSum(new int[]{3, 2, 4, 6}, 6);
        for (int i : sol) {
            System.out.print(i + " ");
        }
    }

    private int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                return new int[]{i, index};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}

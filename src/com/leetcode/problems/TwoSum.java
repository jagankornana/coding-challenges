package com.leetcode.problems;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/
 * Time complexity - O(n)
 * Space complexity - O(n)
 * Tags - Arrays, HashMap
 */
public class TwoSum {

  public static void main(String[] args) {
    TwoSum target = new TwoSum();
    int[] result = target.twoSum(new int[]{1, 2, 3, 4}, 8);
    System.out.println(result.length > 0 ? result[0] + ", " + result[1] : "No solution");
  }

  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      Integer secondIndex = map.get(target - nums[i]);
      if (secondIndex != null) {
        return new int[]{i, secondIndex};
      } else {
        map.put(nums[i], i);
      }
    }
    return new int[]{};
  }
}

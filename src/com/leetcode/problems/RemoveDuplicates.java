package com.leetcode.problems;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Time complexity - O(n)
 * Space complexity - O(1)
 * Tags - Arrays, Two Pointers
 */
public class RemoveDuplicates {
  public static void main(String[] args) {
    RemoveDuplicates input = new RemoveDuplicates();
    int[] inputArr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    int resultArrSize = input.removeDuplicates(inputArr);
    System.out.println(resultArrSize);
    for (int i = 0; i < resultArrSize; i++) {
      System.out.print(inputArr[i] + " ");
    }
  }

  public int removeDuplicates(int[] nums) {
    int i = 0;
    for (int j = 0; j < nums.length; j++) {
      if (nums[i] != nums[j]) {
        nums[++i] = nums[j];
      }
    }
    return i + 1;
  }
}

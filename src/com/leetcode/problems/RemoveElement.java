package com.leetcode.problems;

public class RemoveElement {
  public static void main(String[] args) {
    RemoveElement input = new RemoveElement();
    int[] nums = new int[]{2, 2, 3, 2, 5};
//    System.out.println(input.removeElement_1(nums, 2));
    System.out.println(input.removeElement_2(nums, 2));
    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i] + " ");
    }
  }

  public int removeElement_1(int[] nums, int val) {
    int i = -1;
    for (int j = 0; j < nums.length; j++) {
      if (i < 0 && nums[j] == val) {
        i = j;
      } else if (i >= 0 && nums[j] != val) {
        nums[i++] = nums[j];
      }
    }
    return i == -1 ? nums.length : i;
  }

  public int removeElement_2(int[] nums, int val) {
    int i = 0;
    int n = nums.length;
    while (i < n) {
      if (nums[i] == val) {
        nums[i] = nums[n - 1];
        n--;
      } else {
        i++;
      }
    }
    return n;
  }

}

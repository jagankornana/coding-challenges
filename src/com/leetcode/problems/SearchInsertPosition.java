package com.leetcode.problems;

/**
 * https://leetcode.com/problems/search-insert-position/
 * Time complexity - O(log n)
 * Space complexity - O(1)
 * Tags - Arrays, BinarySearch
 */
public class SearchInsertPosition {
  public static void main(String[] args) {
    SearchInsertPosition input = new SearchInsertPosition();
    int index = input.searchInsert(new int[]{3, 4, 6, 8, 9, 11, 12, 13, 45, 48, 59}, 19);
    System.out.println(index);
  }

  public int searchInsert(int[] nums, int target) {
    int low = 0, mid, high = nums.length - 1;
    while (low <= high) {
      mid = (low + high) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }
}

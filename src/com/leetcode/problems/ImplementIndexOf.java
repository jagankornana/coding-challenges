package com.leetcode.problems;

/**
 * https://leetcode.com/problems/implement-strstr/
 */
public class ImplementIndexOf {
  public static void main(String[] args) {
    ImplementIndexOf input = new ImplementIndexOf();
    System.out.println(input.indexOf("baaab", "ab"));
  }

  /**
   * TC - O(m*n)
   * SC - O(m*n)
   */
  public int indexOf(String haystack, String needle) {
    if (needle.length() == 0) {
      return 0;
    }
    char[] haystackArr = haystack.toCharArray();
    char[] needleArr = needle.toCharArray();
    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
      for (int j = 0; j < needle.length(); j++) {
        if (haystackArr[i + j] != needleArr[j]) {
          break;
        }
        if (j == (needle.length() - 1)) {
          return i;
        }
      }
    }
    return -1;
  }
}

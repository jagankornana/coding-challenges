package com.leetcode.problems;

/**
 * https://leetcode.com/problems/palindrome-number/
 * Time complexity - O(log10(n))
 * Space complexity - O(1)
 * Tags - Math, Modulo
 */
public class PalindromeNumber {
  public static void main(String[] args) {
    PalindromeNumber input = new PalindromeNumber();
    System.out.println(input.isPalindrome_1(1001));
    System.out.println(input.isPalindrome_2(1001));
  }

  public boolean isPalindrome_1(int x) {
    if (x < 0) {
      return false;
    }
    int num = x;
    int result = 0;
    while (num > 0) {
      result = result * 10 + num % 10;
      num /= 10;
    }
    return x == result;
  }

  public boolean isPalindrome_2(int x) {
    if (x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }
    int revertedNum = 0;
    while (x > revertedNum) {
      revertedNum = revertedNum * 10 + x % 10;
      x /= 10;
    }
    return x == revertedNum || x == revertedNum / 10;
  }
}

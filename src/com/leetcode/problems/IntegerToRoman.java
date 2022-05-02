package com.leetcode.problems;

/**
 * https://leetcode.com/problems/integer-to-roman/
 * Time complexity -
 * Space complexity - O(1)
 * Tags - Math, HashTable, String
 */
public class IntegerToRoman {
  public static void main(String[] args) {
    IntegerToRoman input = new IntegerToRoman();
    System.out.println(input.intToRoman(999));
  }

  public String intToRoman(int num) {
    StringBuilder romanString = new StringBuilder();
    int[] integers = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] romanValues = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    for (int i = 0; i < integers.length; i++) {
      while (num >= integers[i]) {
        romanString.append(romanValues[i]);
        num -= integers[i];
      }
    }
    return romanString.toString();
  }
}

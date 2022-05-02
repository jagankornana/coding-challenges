package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * Time complexity - O(n) where n is the length of the string
 * Space complexity - O(1)
 * Tags - Math, HashTable, String
 */
public class RomanToInteger {

  private static Map<Character, Integer> romanToIntMap;

  static {
    romanToIntMap = new HashMap<>();
    romanToIntMap.put('I', 1);
    romanToIntMap.put('V', 5);
    romanToIntMap.put('X', 10);
    romanToIntMap.put('L', 50);
    romanToIntMap.put('C', 100);
    romanToIntMap.put('D', 500);
    romanToIntMap.put('M', 1000);
  }

  public static void main(String[] args) {
    RomanToInteger input = new RomanToInteger();
    System.out.println(input.romanToInt_1("CCXLIV"));
    System.out.println(input.romanToInt_2("CCXLIV"));
  }

  public int romanToInt_1(String s) {
    int curNum, nextNum, sum = 0;
    for (int i = 0; i < s.length() - 1; i++) {
      curNum = romanToIntMap.get(s.charAt(i));
      nextNum = romanToIntMap.get(s.charAt(i + 1));
      sum = curNum < nextNum ? sum - curNum : sum + curNum;
    }
    return sum + romanToIntMap.get(s.charAt(s.length() - 1));
  }

  public int romanToInt_2(String s) {
    int curNum, nextNum, sum = 0;
    for (int i = 0; i < s.length() - 1; i++) {
      curNum = getRomanCharValue(s.charAt(i));
      nextNum = getRomanCharValue(s.charAt(i + 1));
      sum = curNum < nextNum ? sum - curNum : sum + curNum;
    }
    return sum + getRomanCharValue(s.charAt(s.length() - 1));
  }

  private int getRomanCharValue(char ch) {
    switch (ch) {
      case 'I':
        return 1;
      case 'V':
        return 5;
      case 'X':
        return 10;
      case 'L':
        return 50;
      case 'C':
        return 100;
      case 'D':
        return 500;
      case 'M':
        return 1000;
      default:
        return 0;
    }
  }
}

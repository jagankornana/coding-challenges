package com.leetcode.problems;

public class LengthOfLastWord {
  public static void main(String[] args) {
    LengthOfLastWord input = new LengthOfLastWord();
    int length = input.lengthOfLastWord("   fly me   to   the moon  ");
    System.out.println(length);
  }

  public int lengthOfLastWord(String s) {
    s = s.trim();
    return s.length() - s.lastIndexOf(' ') - 1;
  }
}

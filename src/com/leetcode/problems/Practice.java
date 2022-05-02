package com.leetcode.problems;

public class Practice {
  public static void main(String[] args) {
    System.out.println(gcd(500, 246));
  }

  private static int gcd(int a, int b) {
    if (a == 0) {
      return b;
    } else if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }
}

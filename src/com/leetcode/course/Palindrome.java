package com.leetcode.course;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abc"));
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("abcba"));
    }

    private static boolean isPalindrome(String input) {
        int i = 0;
        int j = input.length() - 1;

        while (i < j) {
            if (input.charAt(i) != input.charAt(j))
                return false;
            i += 1;
            j -= 1;
        }
        return true;
    }
}
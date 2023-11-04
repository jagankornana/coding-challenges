package com.poc.practice;

public class Subsequence {

    public static void main(String[] args) {
        Subsequence subsequence = new Subsequence();
        System.out.println(subsequence.isSubsequence("abc", "asldfjljxlfjs"));
    }

    //two-pointer
    private boolean isSubsequence(String s, String t) {
        int p1 = 0, p2 = 0;
        int l1 = s.length(), l2 = t.length();
        char[] arr1 = s.toCharArray(), arr2 = t.toCharArray();
        while (p1 < l1 && p2 < l2) {
            if (arr1[p1] == arr2[p2]) {
                p1++;
            }
            p2++;
        }
        return p1 == l1;
    }

    /* better to store str lengths in a variables and also copy the strings to arrays
    for easy access with index */
    public boolean isSubsequence_1(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}

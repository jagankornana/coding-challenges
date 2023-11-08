package com.leetcode.course;

import java.util.HashSet;

public class LongestSubstrWithoutRepeatingChars {

    public static void main(String[] args) {
        LongestSubstrWithoutRepeatingChars obj = new LongestSubstrWithoutRepeatingChars();
        System.out.println(obj.lengthOfLongestSubstring("%$#   q@ "));
    }

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        char[] strArr = s.toCharArray();
        int i = 0, maxLength = 0;
        for (int j = 0; j < s.length(); j++) {
            while (hashSet.contains(strArr[j])) {
                hashSet.remove(strArr[i++]);
            }
            maxLength = Math.max(maxLength, j - i + 1);
            hashSet.add(strArr[j]);
        }

        return maxLength;
    }
}

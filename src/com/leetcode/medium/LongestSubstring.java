package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("caabcdefabf"));
        System.out.println(lengthOfLongestSubstring("a"));
    }

    private static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, strLength = s.length(), maxLength = 0;
        while (j < strLength) {
            char ch = s.charAt(j);
            Integer idx = map.get(ch);
            if (idx != null) {
                if (maxLength < map.size()) {
                    maxLength = map.size();
                }
                while (i <= idx) {
                    map.remove(s.charAt(i));
                    i++;
                }
                map.put(ch, j);
            } else {
                map.put(ch, j);
            }
            j++;
        }
        if (maxLength < map.size()) {
            maxLength = map.size();
        }

        return maxLength;
    }
}

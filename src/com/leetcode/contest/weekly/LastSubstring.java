package com.leetcode.contest.weekly;

import java.util.ArrayList;
import java.util.List;

public class LastSubstring {

    public static void main(String[] args) {
        LastSubstring sol = new LastSubstring();
        System.out.println(sol.lastSubstring("abab"));
        System.out.println(sol.lastSubstring("leetcode"));
        System.out.println(sol.lastSubstring("aaaaaaaaaa"));
        System.out.println(sol.lastSubstring("xbylisvborylklftlkcioajuxwdhahdgezvyjbgaznzayfwsaumeccpfwamfzmkinezzwobllyxktqeibfoupcpptncggrdqbkji"));
    }

    private String lastSubstring(String s) {
        int len = s.length();
        List<Integer> indexes = new ArrayList<>();
        char ch = 'a';
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) > ch) {
                indexes.clear();
                ch = s.charAt(i);
                indexes.add(i);
            } else if (s.charAt(i) == ch) {
                indexes.add(i);
            }
        }
        String result = s.substring(indexes.get(0));
        for (int i = 1; i < indexes.size(); i++) {
            if (result.compareTo(s.substring(indexes.get(i))) < 0) {
                result = s.substring(indexes.get(i));
            }
        }

        return result;
    }
}

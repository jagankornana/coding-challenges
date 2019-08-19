package com.leetcode.contest.weekly;

/**
 * Given a string s, return the last substring of s in lexicographical order.
 */
public class LastSubstring {

    public static void main(String[] args) {
        LastSubstring sol = new LastSubstring();
        System.out.println(sol.lastSubstring("abab"));
        System.out.println(sol.lastSubstring("leetcode"));
        System.out.println(sol.lastSubstring("xbylisvborylklftlkcioajuxwdhahdgezvyjbgaznzayfwsaumeccpfwamfzmkinezzwobllyxktqeibfoupcpptncggrdqbkji"));
    }

    private String lastSubstring(String s) {
        char ch = 'a';
        String maxStr = "";
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (ch <= s.charAt(i) && maxStr.compareTo(s.substring(i)) <= 0) {
                ch = s.charAt(i);
                maxStr = s.substring(i);
            }
            while (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) i++;
        }
        return maxStr;
    }
}

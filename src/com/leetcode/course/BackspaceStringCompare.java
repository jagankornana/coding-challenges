package com.leetcode.course;

public class BackspaceStringCompare {

    public static void main(String[] args) {
        BackspaceStringCompare obj = new BackspaceStringCompare();
        System.out.println(obj.backspaceCompare("y#fo##f", "y#f#o##f"));
    }

    public boolean backspaceCompare(String s, String t) {
        StringBuilder s1 = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch != '#') {
                s1.append(ch);
            } else if (s1.length() != 0) {
                s1.deleteCharAt(s1.length() - 1);
            }
        }

        StringBuilder t1 = new StringBuilder();
        for (char ch : t.toCharArray()) {
            if (ch != '#') {
                t1.append(ch);
            } else if (t1.length() != 0) {
                t1.deleteCharAt(t1.length() - 1);
            }
        }

        return s1.toString().equals(t1.toString());
    }
}

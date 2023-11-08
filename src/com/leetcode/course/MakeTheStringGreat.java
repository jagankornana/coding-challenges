package com.leetcode.course;

import java.util.Stack;

public class MakeTheStringGreat {

    public static void main(String[] args) {
        MakeTheStringGreat obj = new MakeTheStringGreat();
        System.out.println(obj.makeGood("abBaaaaA"));
    }

    public String makeGood(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(stack.peek() - ch) == 32) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        char[] charArr = new char[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            charArr[i] = stack.pop();
        }
        return new String(charArr);
    }
}

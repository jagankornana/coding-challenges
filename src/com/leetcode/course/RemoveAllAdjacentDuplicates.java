package com.leetcode.course;

import java.util.Stack;

public class RemoveAllAdjacentDuplicates {

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicates obj = new RemoveAllAdjacentDuplicates();
        System.out.println(obj.removeDuplicates("aaabbc"));
    }

    public String removeDuplicates(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }
}

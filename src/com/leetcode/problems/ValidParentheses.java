package com.leetcode.problems;

import java.util.Stack;

public class ValidParentheses {
  public static void main(String[] args) {
    ValidParentheses input = new ValidParentheses();
    System.out.println(input.isValid("(){}[]"));
  }

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char ch : s.toCharArray()) {
      if (ch == '(' || ch == '[' || ch == '{') {
        stack.push(ch);
      } else if (ch == ')') {
        if (stack.isEmpty() || stack.pop() != '(') {
          return false;
        }
      } else if (ch == ']') {
        if (stack.isEmpty() || stack.pop() != '[') {
          return false;
        }
      } else if (ch == '}') {
        if (stack.isEmpty() || stack.pop() != '{') {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}

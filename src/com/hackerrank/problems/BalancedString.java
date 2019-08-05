package com.hackerrank.problems;

import java.util.Stack;

public class BalancedString {

	public String braces(String str) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
			} else if ((!stack.isEmpty()) && ((ch == ')' && stack.peek()=='(') || (ch == ']' && stack.peek()=='[') || (ch == '}' && stack.peek()=='{'))) {
				stack.pop();
			} else {
				return "NO";
			}
		}

		if (stack.isEmpty()) {
			return "YES";
		} else {
			return "NO";
		}
	}
	
	public static void main(String[] args) {
		BalancedString bs = new BalancedString();
		System.out.println(bs.braces("{{}}}"));
	}
}

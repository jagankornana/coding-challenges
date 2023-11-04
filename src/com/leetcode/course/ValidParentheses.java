package com.poc.practice;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses obj = new ValidParentheses();
        System.out.println(obj.isValid("(((()))"));
    }

    public boolean isValid(String str) {
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('{', '}');
        hashMap.put('[', ']');
        hashMap.put('(', ')');
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (hashMap.containsKey(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || hashMap.get(stack.pop()) != ch) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

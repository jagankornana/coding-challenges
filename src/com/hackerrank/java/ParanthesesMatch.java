package com.hackerrank.java;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class ParanthesesMatch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack;
        while (sc.hasNext()) {
            stack = new Stack<>();
            boolean flag = true;
            String str = sc.next();
            char[] charArray = str.toCharArray();
            for (char c : charArray) {
                if (c == '(' || c == '{' || c == '[')
                    stack.push(c);
                else if (c == ')' || c == '}' || c == ']')
                    try {
                        stack.pop();
                    } catch (EmptyStackException e) {
                        System.out.println("false");
                        flag = false;
                        break;
                    }
                //System.out.println(stack.toString());
            }
            if (flag) {
                if (stack.isEmpty())
                    System.out.println("true");
                else
                    System.out.println("false");
            }
        }
        sc.close();
    }
}
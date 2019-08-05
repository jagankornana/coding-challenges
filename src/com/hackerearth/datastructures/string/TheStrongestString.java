package com.hackerearth.datastructures.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class TheStrongestString {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean[] mask = new boolean[26];
        stack.push(str.charAt(0));
        mask[str.charAt(0) - 'a'] = true;
        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!mask[ch - 'a']) {
                if (ch < stack.peek()) {
                    stack.push(ch);
                    mask[ch - 'a'] = true;
                } else {
                    do {
                        mask[stack.pop() - 'a'] = false;
                        if (stack.isEmpty()) {
                            break;
                        }
                    } while (ch > stack.peek());
                    stack.push(ch);
                    mask[ch - 'a'] = true;
                }
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pollLast());
        }
    }
}

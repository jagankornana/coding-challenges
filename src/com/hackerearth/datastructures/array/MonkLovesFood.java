package com.hackerearth.datastructures.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MonkLovesFood {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int query = 0; query < q; query++) {
            String[] nums = br.readLine().split(" ");
            if (nums.length == 1) {
                if (stack.isEmpty()) {
                    System.out.println("No Food");
                } else {
                    System.out.println(stack.pop());
                }
            } else {
                stack.push(Integer.parseInt(nums[1]));
            }
        }
    }
}

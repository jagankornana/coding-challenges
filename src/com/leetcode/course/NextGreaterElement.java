package com.poc.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        NextGreaterElement obj = new NextGreaterElement();
        int[] nums1 = {2,1};
        int[] nums2 = {2,1};
        System.out.println(Arrays.toString(obj.nextGreaterElement(nums1, nums2)));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int n = nums2.length;
        hashMap.put(nums2[n - 1], -1);
        stack.push(nums2[n - 1]);
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            int nextMax = stack.isEmpty() ? -1 : stack.peek();
            hashMap.put(nums2[i], nextMax);
            stack.push(nums2[i]);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = hashMap.get(nums1[i]);
        }

        return result;
    }
}

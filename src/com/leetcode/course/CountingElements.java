package com.poc.practice;

import java.util.HashSet;

public class CountingElements {

    public static void main(String[] args) {
        CountingElements obj = new CountingElements();
        System.out.println(obj.countElements(new int[]{1, 2, 2, 3, 3, 3, 4}));
    }

    public int countElements(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        int count = 0;
        for (int num : nums) {
            if (hashSet.contains(num + 1)) {
                count++;
            }
        }

        return count;
    }
}

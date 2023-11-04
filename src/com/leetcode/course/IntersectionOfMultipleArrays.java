package com.poc.practice;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfMultipleArrays {

    public static void main(String[] args) {
        IntersectionOfMultipleArrays obj = new IntersectionOfMultipleArrays();
        int[][] input = { {1, 2, 3, 4}, { 1}};
        System.out.println(obj.intersection(input));
    }

    public List<Integer> intersection(int[][] nums) {
        int[] freq = new int[1001];
        for (int[] arr : nums) {
            for (int element : arr) {
                freq[element]++;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == nums.length) {
                result.add(i);
            }
        }

        return result;
    }
}

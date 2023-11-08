package com.leetcode.course;

import java.util.ArrayList;

public class MergeArrays {
    public static void main(String[] args) {
        mergeTwoSortedArrays(new int[]{2, 2, 2, 2, 2}, new int[]{1, 10000});
    }

    public static void mergeTwoSortedArrays(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result.add(arr1[i++]);
            } else {
                result.add(arr2[j++]);
            }
        }
        while (i < arr1.length) {
            result.add(arr1[i++]);
        }
        while (j < arr2.length) {
            result.add(arr2[j++]);
        }
        System.out.println(result);
    }
}

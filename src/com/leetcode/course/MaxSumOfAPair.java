package com.poc.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MaxSumOfAPair {

    public static void main(String[] args) {
        MaxSumOfAPair obj = new MaxSumOfAPair();
        int[] input =
                {229, 398, 269, 317, 420, 464, 491, 218, 439, 153, 482, 169, 411, 93, 147, 50, 347, 210, 251, 366, 401};
        System.out.println(obj.maximumSum(input));
    }

    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int maxValue = 0;
        for (int num : nums) {
            int digitSum = getDigitSum(num);
            if (hashMap.containsKey(digitSum)) {
                maxValue = Math.max(maxValue, num + hashMap.get(digitSum));
            }
            hashMap.put(digitSum, Math.max(hashMap.getOrDefault(digitSum, 0), num));
        }
        return maxValue == 0 ? -1 : maxValue;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public int maximumSum_Inefficient(int[] nums) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int num : nums) {
            int sum = 0, value = num;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            if (!hashMap.containsKey(sum)) {
                hashMap.put(sum, new ArrayList<>());
            }
            hashMap.get(sum).add(value);
        }

        int maxValue = 0;
        for (List<Integer> list : hashMap.values()) {
            if (list.size() < 2) {
                continue;
            }
            list.sort((a, b) -> b - a);
            maxValue = Math.max(maxValue, list.get(0) + list.get(1));
        }

        return maxValue == 0 ? -1 : maxValue;
    }
}

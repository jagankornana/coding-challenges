package com.poc.practice;

public class MissingNumber {

    public static void main(String[] args) {
        MissingNumber obj = new MissingNumber();
        System.out.println(obj.missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));
    }

    public int missingNumber(int[] nums) {
        int totalSum = (nums.length * (nums.length + 1)) / 2;
        int numsSum = 0;
        for (int num : nums) {
            numsSum += num;
        }
        return totalSum - numsSum;
    }
}

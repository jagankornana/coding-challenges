package com.hackerearth.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HaveYouMetTed {


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] strings = br.readLine().split(" ");
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = Integer.parseInt(strings[j]);
            }

            int result = 100000000;
            for (int num : nums) {
                int setBitCount = numOfSetBits(num);
                if (setBitCount < result) {
                    result = setBitCount;
                }
            }
            System.out.println(result);
        }
    }

    private static int numOfSetBits(int num) {
        int count = 0;
        while (num > 0) {
            num &= num - 1;
            count++;
        }
        return count;
    }
}

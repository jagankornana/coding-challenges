package com.hackerearth.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MonkAndHisFriend {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] nums = br.readLine().split(" ");
            long p = Long.parseLong(nums[0]);
            long m = Long.parseLong(nums[1]);

            int count = 0;
            for (int j = 0; j < Long.SIZE; j++) {
                boolean flag1 = (p & (1L << j)) > 0;
                boolean flag2 = (m & (1L << j)) > 0;
                if (flag1 != flag2)
                    count++;
            }
            System.out.println(count);
        }
    }
}

package com.hackerearth.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumAND {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] nums = br.readLine().split(" ");
            long a = Long.parseLong(nums[0]);
            long b = Long.parseLong(nums[1]);

            if ((b - a) == 1) {
                System.out.println(a & b);
            } else {
                if (b % 2 == 0)
                    System.out.println(b - 2);
                else
                    System.out.println(b - 1);
            }
        }
    }
}

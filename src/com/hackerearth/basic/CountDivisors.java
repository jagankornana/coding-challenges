package com.hackerearth.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountDivisors {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int l = Integer.parseInt(nums[0]);
        int r = Integer.parseInt(nums[1]);
        int k = Integer.parseInt(nums[2]);

        int count = 0;

        for (int i = l; i <= r; ) {
            if (i % k == 0) {
                count++;
                i += k;
            } else {
                i++;
            }
        }

        System.out.println(count);
    }
}

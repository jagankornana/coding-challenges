package com.hackerearth.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfNumbers {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] strings = br.readLine().split(" ");
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = Integer.parseInt(strings[j]);
            }
            long s = Integer.parseInt(br.readLine());

            boolean flag = true;
            for (long j = 1; j < 1L << n; j++) {
                long sum = 0;
                for (int k = 0; k < n; k++) {
                    if ((j & (1L << k)) > 0) {
                        sum += nums[k];
                    }
                }

                if (s == sum) {
                    System.out.println("YES");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("NO");
            }
        }
    }
}

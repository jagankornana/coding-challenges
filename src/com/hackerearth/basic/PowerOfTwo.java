package com.hackerearth.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PowerOfTwo {

    private static int total;

    static {
        for (int i = 0; i < Integer.SIZE; i++) {
            total += 1 << i;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            String[] strings = br.readLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(strings[i]);
            }

            boolean flag = true;
            for (int num : nums) {
                if (isPowerOf2(num)) {
                    System.out.println("YES1");
                    flag = false;
                    break;
                }
            }

            if (flag) {
                for (int i = 0; i < Integer.SIZE; i++) {
                    int result = total;
                    for (int num : nums) {
                        if ((num & (1 << i)) != 0) {
                            result &= num;
                        }
                    }
                    if (isPowerOf2(result)) {
                        System.out.println("YES2");
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

    private static boolean isPowerOf2(int i) {
        if (i == 0)
            return false;
        return ((i & (i - 1)) == 0);
    }
}

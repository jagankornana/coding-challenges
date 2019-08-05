package com.hackerearth.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubsetAND {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] nums = br.readLine().split(" ");
            int z = Integer.parseInt(nums[0]);
            int n = Integer.parseInt(nums[1]);
            nums = br.readLine().split(" ");
            int[] set = new int[n];
            for (int j = 0; j < n; j++) {
                set[j] = Integer.parseInt(nums[j]);
            }

            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if ((z & set[j]) == 0) {
                    System.out.println("Yes");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                outerloop:
                for (int j = 0; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if ((z & set[j] & set[k]) == 0) {
                            System.out.println("Yes");
                            flag = false;
                            break outerloop;
                        }
                    }
                }
            }

            if (flag) {
                System.out.println("No");
            }
        }
    }
}

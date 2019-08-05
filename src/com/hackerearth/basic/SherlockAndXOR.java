package com.hackerearth.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SherlockAndXOR {

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

            int[] arr = new int[n];
            int even = 0;
            int odd = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (nums[j] % 2 == 0) {
                    even++;
                    arr[j] = odd;
                } else {
                    odd++;
                    arr[j] = even;
                }
            }

            long result = 0;
            for (int anArr : arr) {
                result += anArr;
            }

            System.out.println(result);
        }
    }
}

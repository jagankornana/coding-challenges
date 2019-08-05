package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheMagic {

    public static int base2(long num) {
        return Long.toBinaryString(num).length() - 1;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            int numOfDays = 0;
            while (num > 0) {
                int x = base2(num);
                num -= Math.pow(2, x);
                numOfDays++;
            }
            System.out.println(numOfDays);
        }
    }
}

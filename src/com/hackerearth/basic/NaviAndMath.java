package com.hackerearth.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class NaviAndMath {

    private static BigInteger MOD = new BigInteger("1000000007");

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] strings = br.readLine().split(" ");
            BigInteger[] nums = new BigInteger[n];
            for (int j = 0; j < n; j++) {
                nums[j] = new BigInteger(strings[j]);
            }

            long result = 0;
            for (long j = 3; j < 1L << n; j++) {

                if ((j & (j - 1)) == 0) {
                    continue;
                }

                BigInteger multi = BigInteger.ONE;
                BigInteger sum = BigInteger.ZERO;
                for (int k = 0; k < n; k++) {
                    if ((j & (1L << k)) > 0) {
                        multi = (multi.multiply(nums[k]));
                        sum = (sum.add(nums[k]));
                    }
                }

                long p_mod = multi.divide(sum).mod(MOD).longValue();
                if (p_mod > result) {
                    result = p_mod;
                }
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
}

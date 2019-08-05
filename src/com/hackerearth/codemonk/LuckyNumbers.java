package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class LuckyNumbers {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            if (num == 1 || num == 2) {
                System.out.println(0);
                continue;
            }
            long sum = 0;
            int numOfBits = Long.toBinaryString(num).length();
            char[] binaryArray = new char[numOfBits];
            Arrays.fill(binaryArray, '0');
            for (int x = 0; x < numOfBits - 1; x++) {
                binaryArray[x] = '1';
                for (int y = x + 1; y < numOfBits; y++) {
                    binaryArray[y] = '1';
                    //System.out.println(binaryArray);
                    long value = new BigInteger(new String(binaryArray), 2).longValue();
                    if (value <= num)
                        sum = (sum + (value % 1000000007)) % 1000000007;
                    binaryArray[y] = '0';
                }
                binaryArray[x] = '0';
            }
            System.out.println(sum);
        }
    }

}

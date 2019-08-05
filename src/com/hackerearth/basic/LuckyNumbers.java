package com.hackerearth.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LuckyNumbers {

    private static long[][] memory = new long[Long.SIZE][Long.SIZE];

    static {
        long sum = 0;
        for (int i = 1; i < Long.SIZE; i++) {
            long num = 1;
            num <<= i;
            for (int j = 0; j < i; j++) {
                long temp = 1;
                temp = num | (temp << j);
                sum = (sum + temp) % 1000000007;
                memory[i][j] = sum;
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Long.parseLong(br.readLine());

        for (long i = 0; i < t; i++) {
            long n = Long.parseLong(br.readLine());
            if (n == 1 || n == 2) {
                System.out.println("0");
            } else if (isPowerOf2(n)) {
                System.out.println(sumOfLuckyNumbers(n - 1));
            } else {
                System.out.println(sumOfLuckyNumbers(n));
            }
        }
    }

    private static boolean isPowerOf2(long n) {
        return (n & (n - 1)) == 0;
    }

    private static long sumOfLuckyNumbers(long n) {
        int i = findSetBit(n, 1);
        int j = findSetBit(n, 2);
        return memory[i][j];
    }

    private static int findSetBit(long n, int occurrence) {
        String binaryOfNum = Long.toBinaryString(n);
        int count = 0;
        int i = 0;
        for (; i < binaryOfNum.length(); i++) {
            if (binaryOfNum.charAt(i) == '1') {
                count++;
            }
            if (count == occurrence) {
                break;
            }
        }
        return binaryOfNum.substring(i).length() - 1;
    }

}

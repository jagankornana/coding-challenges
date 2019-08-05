package com.hackerearth.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatteyMultiplication {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < t; testCase++) {
            String[] strings = br.readLine().split(" ");
            long n = Long.parseLong(strings[0]);
            long m = Long.parseLong(strings[1]);

            int[] setBitIndex = new int[Long.SIZE];
            int index = 0;
            int i = 0;
            while (m != 0) {
                if ((m & 1L) != 0)
                    setBitIndex[i++] = index;
                m >>= 1;
                index++;
            }

            while (--i >= 0) {
                if (i != 0) {
                    System.out.print("(" + n + "<<" + setBitIndex[i] + ") + ");
                } else {
                    System.out.print("(" + n + "<<" + setBitIndex[i] + ")");
                }
            }
            System.out.println();
        }
    }
}

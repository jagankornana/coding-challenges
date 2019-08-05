package com.hackerearth.datastructures.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoArraysAndMinimum {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        long a = Long.parseLong(strings[0]);
        long b = Long.parseLong(strings[1]);
        long c = Long.parseLong(strings[2]);
        int n = Integer.parseInt(br.readLine());

        long[] arrayA = new long[n];
        long abc = (((a * b) % 1000000007) * c) % 1000000007;
        long ab = (a * b) % 1000000007;
        long ac = (a * c) % 1000000007;
        long bc = (b * c) % 1000000007;
        arrayA[0] = ac;
        for (int i = 1; i < n; i++) {
            long multi1 = (arrayA[i - 1] * abc) % 1000000007;
            long multi2 = (arrayA[i - 1] * ab) % 1000000007;
            long multi3 = (arrayA[i - 1] * ac) % 1000000007;
            arrayA[i] = (((multi1 + multi2) % 1000000007) + multi3) % 1000000007;
        }

        long[] arrayB = new long[n];
        arrayB[0] = bc;
        for (int i = 1; i < n; i++) {
            long multi1 = (arrayB[i - 1] * abc) % 1000000007;
            long multi2 = (arrayB[i - 1] * ab) % 1000000007;
            long multi3 = (arrayB[i - 1] * bc) % 1000000007;
            arrayB[i] = (((multi1 + multi2) % 1000000007) + multi3) % 1000000007;
        }


        long firstMinA = arrayA[0];
        long firstMinB = arrayB[0];
        int indexA = 0;
        int indexB = 0;
        for (int i = 1; i < n; i++) {
            if (arrayA[i] < firstMinA) {
                firstMinA = arrayA[i];
                indexA = i;
            }

            if (arrayB[i] < firstMinB) {
                firstMinB = arrayB[i];
                indexB = i;
            }
        }

        if (indexA != indexB) {
            System.out.println(firstMinA + firstMinB);

        } else {
            long secondMinA = 999999999999L;
            long secondMinB = 999999999999L;
            for (int i = 0; i < n; i++) {
                if (i == indexA) {
                    continue;
                }
                if (arrayA[i] < secondMinA) {
                    secondMinA = arrayA[i];
                }

                if (arrayB[i] < secondMinB) {
                    secondMinB = arrayB[i];
                }
            }

            long sum1 = firstMinA + secondMinB;
            long sum2 = firstMinB + secondMinA;

            if (sum1 < sum2) {
                System.out.println(sum1);
            } else {
                System.out.println(sum2);
            }
        }
    }
}

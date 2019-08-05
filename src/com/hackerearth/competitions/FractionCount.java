package com.hackerearth.competitions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FractionCount {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (gcd(j, i) == 1) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}

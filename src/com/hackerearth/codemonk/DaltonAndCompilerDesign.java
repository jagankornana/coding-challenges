package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DaltonAndCompilerDesign {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(
                System.in));
        int t = Integer.parseInt(input.readLine());
        int[] n = new int[t];
        for (int i = 0; i < t; i++) {
            n[i] = Integer.parseInt(input.readLine());
        }

        int ans;
        for (int i = 0; i < t; i++) {
            if (n[i] % 2 == 0) {
                ans = n[i] / 2;
                System.out.println(ans + " " + ans);
            } else {
                ans = (n[i] - 1) / 2;
                System.out.println(ans + " " + ++ans);
            }

        }
    }
}

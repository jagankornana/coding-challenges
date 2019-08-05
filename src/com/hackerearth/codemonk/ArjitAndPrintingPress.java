package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArjitAndPrintingPress {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            char[] w = br.readLine().toCharArray();
            char[] r = br.readLine().toCharArray();
            Arrays.sort(r);
            int k = 0;
            for (int j = 0; (j < w.length) && (k < r.length); j++) {
                if (w[j] > r[k]) {
                    w[j] = r[k];
                    k++;
                }
            }
            System.out.println(String.valueOf(w));
        }
    }
}

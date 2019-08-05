package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SamuAndShopping {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] prices = new int[n][3];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                prices[j][0] = Integer.parseInt(st.nextToken());
                prices[j][1] = Integer.parseInt(st.nextToken());
                prices[j][2] = Integer.parseInt(st.nextToken());
            }
            int[][] cache = new int[n][3];
            System.arraycopy(prices[0], 0, cache[0], 0, 3);

            for (int j = 1; j < n; j++) {
                cache[j][0] = Math.min(cache[j - 1][1], cache[j - 1][2]) + prices[j][0];
                cache[j][1] = Math.min(cache[j - 1][0], cache[j - 1][2]) + prices[j][1];
                cache[j][2] = Math.min(cache[j - 1][0], cache[j - 1][1]) + prices[j][2];
            }
            int ans = Math.min(Math.min(cache[n - 1][0], cache[n - 1][1]), cache[n - 1][2]);
            System.out.println(ans);
        }
    }
}

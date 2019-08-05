package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChanduAndHisGirlfriendReturns {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            long[] firstArray = new long[n];
            for (int j = 0; j < n; j++) {
                firstArray[j] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            long[] secondArray = new long[m];
            for (int j = 0; j < m; j++) {
                secondArray[j] = Long.parseLong(st.nextToken());
            }

            int p = 0;
            int q = 0;
            while (p < firstArray.length && q < secondArray.length) {
                if (firstArray[p] >= secondArray[q])
                    System.out.print(firstArray[p++] + " ");
                else
                    System.out.print(secondArray[q++] + " ");
            }
            while (p < firstArray.length)
                System.out.print(firstArray[p++] + " ");
            while (q < secondArray.length)
                System.out.print(secondArray[q++] + " ");
            System.out.println();
        }
    }
}


package com.hackerrank.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class BigDecimalEx {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] bigNums = new String[n];
        for (int i = 0; i < n; i++) {
            bigNums[i] = br.readLine();
        }
        //Selection sort
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (new BigDecimal(bigNums[j]).compareTo(new BigDecimal(bigNums[maxIndex])) > 0)
                    maxIndex = j;
            }
            //swap
            if (i != maxIndex) {
                String temp = bigNums[i];
                bigNums[i] = bigNums[maxIndex];
                bigNums[maxIndex] = temp;
            }
        }

        for (String bigNum : bigNums) {
            System.out.println(bigNum);
        }
    }
}
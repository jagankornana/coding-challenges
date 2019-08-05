package com.hackerearth.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XsquareAndTwoStrings {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String s1 = br.readLine();
            String s2 = br.readLine();
            boolean flag = true;
            for (int j = 0; j < s1.length(); j++) {
                String subsequence = s1.substring(j, j + 1);
                if (s2.contains(subsequence)) {
                    System.out.println("Yes");
                    flag = false;
                    break;
                }
            }
            if (flag)
                System.out.println("No");
        }
    }
}

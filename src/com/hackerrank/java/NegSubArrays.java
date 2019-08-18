package com.hackerrank.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NegSubArrays {
    public static void main(String[] args) throws NumberFormatException,
            IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ", false);
        int[] nums = new int[n];
        for (int i = 0; st.hasMoreTokens(); i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int negSubArrays = 0;
        for (int i = 0; i < n; i++) {
            int arraySum = nums[i];
            for (int j = i; j < n; j++) {
                if (i == j && nums[j] < 0) {
                    negSubArrays++;
                } else if (i != j) {
                    arraySum += nums[j];
                    if (arraySum < 0)
                        negSubArrays++;
                }
            }
        }
        System.out.println(negSubArrays);
    }
}
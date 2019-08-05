package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MonkChoiceOfNumbers {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int[] bitArray = new int[n];
            for (int j = 0; j < n; j++) {
                int value = arr[j];
                int count = 0;
                while (value > 0) {
                    value = value & (value - 1);
                    count++;
                }
                bitArray[j] = count;
            }
            Arrays.sort(bitArray);
            int cheeseCakes = 0;
            for (int j = n - k; j < n; j++) {
                cheeseCakes += bitArray[j];
            }
            System.out.println(cheeseCakes);

        }
    }
}

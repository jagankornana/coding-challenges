package com.hackerearth.datastructures.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Speed {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            String[] strings = br.readLine().split(" ");
            int[] carSpeed = new int[n];
            for (int i = 0; i < strings.length; i++) {
                carSpeed[i] = Integer.parseInt(strings[i]);
            }

            int count = 1;
            for (int i = 1; i < carSpeed.length; i++) {
                if (carSpeed[i] < carSpeed[i - 1]) {
                    count++;
                } else {
                    carSpeed[i] = carSpeed[i - 1];
                }
            }

            System.out.println(count);
        }
    }
}

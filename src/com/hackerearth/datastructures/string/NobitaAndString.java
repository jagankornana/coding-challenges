package com.hackerearth.datastructures.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NobitaAndString {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < t; testCase++) {
            String[] inputWords = br.readLine().split(" ");
            int n = inputWords.length;
            for (int i = 0; i < n / 2; i++) {
                String temp = inputWords[i];
                inputWords[i] = inputWords[n - 1 - i];
                inputWords[n - 1 - i] = temp;
            }

            for (String inputWord : inputWords) {
                System.out.print(inputWord + " ");
            }
            System.out.println();
        }
    }
}

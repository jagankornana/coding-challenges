package com.hackerearth.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubsequencesAndGreatXOR {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strings = br.readLine().split(" ");
        int[] numArray = new int[n];
        for (int i = 0; i < n; i++) {
            numArray[i] = Integer.parseInt(strings[i]);
        }

        int result = 0;
        for (int aNumArray : numArray) {
            result |= aNumArray;
        }
        System.out.println(result);
    }
}

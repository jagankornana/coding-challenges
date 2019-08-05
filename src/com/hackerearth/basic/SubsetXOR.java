package com.hackerearth.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubsetXOR {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] strings = br.readLine().split(" ");
            if (n > 1) {
                System.out.println("0");
            } else {
                System.out.println(Integer.parseInt(strings[0]));
            }
        }
    }
}

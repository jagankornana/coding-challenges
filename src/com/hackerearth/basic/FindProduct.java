package com.hackerearth.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindProduct {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] nums = br.readLine().split(" ");
        long multiValue = 1;
        for (String string : nums) {
            long num = Integer.parseInt(string);
            multiValue = (multiValue * num) % 1000000007;
        }
        System.out.println(multiValue);
    }
}

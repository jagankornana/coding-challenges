package com.hackerearth.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoyAndProfilePicture {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] dimensions = br.readLine().split(" ");
            int w = Integer.parseInt(dimensions[0]);
            int h = Integer.parseInt(dimensions[1]);

            if (w < l || h < l) {
                System.out.println("UPLOAD ANOTHER");
            } else {
                if (w == h) {
                    System.out.println("ACCEPTED");
                } else {
                    System.out.println("CROP IT");
                }
            }
        }

    }
}

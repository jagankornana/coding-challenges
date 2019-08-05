package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerribleChandu {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            System.out.println(new StringBuffer(str).reverse().toString());
        }
    }
}

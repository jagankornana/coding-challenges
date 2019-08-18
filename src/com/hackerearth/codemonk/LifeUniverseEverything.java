package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.InputStreamReader;


class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 42)
                break;
            else
                System.out.println(n);
        }
    }
}

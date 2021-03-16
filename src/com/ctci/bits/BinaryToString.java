package com.ctci.bits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryToString {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter double (0 - 1): ");
        double num = Double.parseDouble(br.readLine());
        StringBuilder binary = new StringBuilder(".");
        boolean flag = true;
        while (num > 0) {
            double temp = num * 2;
            if (temp >= 1) {
                binary.append("1");
                num = temp - 1;
            } else {
                binary.append("0");
                num = temp;
            }
            if (binary.length() > 32) {
                System.out.println("ERROR");
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println(binary);
        }
    }
}

package com.hackerearth.datastructures.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Password {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] passwords = new String[n];
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            passwords[i] = br.readLine();
            set.add(passwords[i]);
        }

        for (String password : passwords) {
            if (set.contains(new StringBuilder(password).reverse().toString())) {
                int length = password.length();
                System.out.print(length + " " + password.charAt(length / 2));
                break;
            }
        }
    }
}

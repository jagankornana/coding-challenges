package com.hackerearth.datastructures.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindromes {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if (checkPalindrome(str)) {
            if (checkPalindrome(str.substring(1))) {
                System.out.println("0");
            } else {
                System.out.println(str.length() - 1);
            }
        } else {
            System.out.println(str.length());
        }
    }

    private static boolean checkPalindrome(String input) {
        int i = 0;
        int j = input.length() - 1;

        while (i <= j) {
            if (input.charAt(i++) != input.charAt(j--)) {
                return false;
            }
        }

        return true;
    }
}

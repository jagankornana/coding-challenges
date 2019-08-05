package com.hackerearth.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromicString {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if (checkPalindrome(input))
            System.out.println("YES");
        else
            System.out.println("NO");
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

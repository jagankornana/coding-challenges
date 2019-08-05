package com.hackerearth.datastructures.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChotuAndPalindrome {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < t; testCase++) {
            String s1 = br.readLine();
            String s2 = br.readLine();
            if (isPalindrome(s1 + s2)) {
                System.out.println("YES");
            } else if (isPalindrome(s2 + s1)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isPalindrome(String string) {
        int i = 0;
        int j = string.length() - 1;
        while (i <= j) {
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

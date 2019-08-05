package com.hackerearth.datastructures.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MarutAndStrings {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 0;
        try {
            t = Integer.parseInt(br.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Test");
            System.exit(0);
        }
        if (t < 1 || t > 10) {
            System.out.println("Invalid Test");
        } else {
            for (int testCase = 0; testCase < t; testCase++) {
                String str = br.readLine();
                if (isValidString(str)) {
                    int lowerCaseLetters = 0;
                    int upperCaseLetters = 0;
                    for (int i = 0; i < str.length(); i++) {
                        char ch = str.charAt(i);
                        if (ch >= 'a' && ch <= 'z') {
                            lowerCaseLetters++;
                        } else if (ch >= 'A' && ch <= 'Z') {
                            upperCaseLetters++;
                        }
                    }

                    if (lowerCaseLetters < upperCaseLetters) {
                        System.out.println(lowerCaseLetters);
                    } else {
                        System.out.println(upperCaseLetters);
                    }
                } else {
                    System.out.println("Invalid Input");
                }
            }
        }
    }

    private static boolean isValidString(String str) {
        if (str.length() > 100) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                return true;
            }
        }

        return false;
    }
}

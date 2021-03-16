package com.ctci.arrays_strings;

/* String Rotation: jagan -> anjag should return true */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringRotation {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1, str2;
        System.out.print("Enter String1: ");
        str1 = br.readLine();
        System.out.print("Enter String2: ");
        str2 = br.readLine();

        if (checkRotation(str1, str2)) {
            System.out.println(str1 + " is rotation of " + str2);
        } else {
            System.out.println(str1 + " is not a rotation of " + str2);
        }
    }

    private static boolean checkRotation(String str1, String str2) {
        if (str1.length() != str2.length() || str1.length() == 0 || str2.length() == 0) {
            return false;
        }
        char ch = str1.charAt(0);
        for (int i = 0; i < str2.length(); i++) {
            if (ch == str2.charAt(i)) {
                if (isValidRotation(str1, str2, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValidRotation(String str1, String str2, int i) {
        int str1Index = 0;
        int str2Index = i;
        while (str2Index < i) {
            if (str1.charAt(str1Index) != str2.charAt(str2Index)) {
                return false;
            }
            str1Index++;
            str2Index++;
            if (str2Index == str2.length()) {
                str2Index = 0;
            }
        }
        return true;
    }
}

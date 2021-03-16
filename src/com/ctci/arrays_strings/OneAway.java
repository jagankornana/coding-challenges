package com.ctci.arrays_strings;

/* There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneAway {

    private static final String INSERTION = "insertion";
    private static final String REMOVAL = "removal";
    private static final String REPLACE = "replace";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter String1: ");
        String str1 = br.readLine();
        System.out.println("Enter String2: ");
        String str2 = br.readLine();
        if (Math.abs(str1.length() - str2.length()) > 1) {
            System.out.println(str1 + " is not possible to become " + str2 + " with one operation");
            return;
        } else if (str1.equals(str2)) {
            System.out.println(str1 + " and " + str2 + " are equal");
            return;
        }
        boolean isOneAway;
        String operation;
        if (str1.length() < str2.length()) {
            isOneAway = insertChar(str1, str2);
            operation = INSERTION;
        } else if (str2.length() < str1.length()) {
            isOneAway = insertChar(str2, str1);
            operation = REMOVAL;
        } else {
            isOneAway = replaceChar(str1, str2);
            operation = REPLACE;
        }

        if (isOneAway) {
            System.out.println(str1 + " is one " + operation + " away from " + str2);
        } else {
            System.out.println(str1 + " is not possible to become " + str2 + " with one operation");
        }
    }

    private static boolean insertChar(String str1, String str2) {
        int index1 = 0;
        int index2 = 0;
        while (index2 < str2.length() && index1 < str1.length()) {
            if (str1.charAt(index1) != str2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    private static boolean replaceChar(String str1, String str2) {
        boolean isCharReplaced = false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (!isCharReplaced) {
                    isCharReplaced = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

package com.ctci.arrays_strings;

import java.util.Scanner;

/* Checking whether unique characters are there or not in the given string */

public class UniqueChars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the input string: ");
        String inputStr = scanner.nextLine();
        if (isUniqueChars(inputStr)) {
            System.out.println("There are unique chars in the given string: " + inputStr);
        } else {
            System.out.println("There are no unique chars in the given string: " + inputStr);
        }
    }

    private static boolean isUniqueChars(String inputStr) {
        if (inputStr.length() > 128) {
            return false;
        }
        boolean[] flags = new boolean[128];
        char ch;
        for (int i = 0; i < inputStr.length(); i++) {
            ch = inputStr.charAt(i);
            if (flags[ch]) {
                return false;
            }
            flags[ch] = true;
        }
        return true;
    }
}

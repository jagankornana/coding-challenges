package com.ctci.arrays_strings;

/* Checking one string is permutation of another string */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CheckPermutation {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter String1: ");
        String str1 = br.readLine();
        System.out.println("Enter String2: ");
        String str2 = br.readLine();
        if (isValidPermutation(str1, str2)) {
            System.out.println("String1 is permutation of String2.");
        } else {
            System.out.println("String1 is not a permutation of String2.");
        }
    }

    private static boolean isValidPermutation(String str1, String str2) {
        if (str1.length() != str2.length()){
            return false;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();
        Character ch;
        for (int i = 0; i < str1.length(); i++) {
            ch = str1.charAt(i);
            if (hashMap.get(ch) == null) {
                hashMap.put(ch, 1);
            } else {
                hashMap.put(ch, hashMap.get(ch) + 1);
            }
        }

        for (int i = 0; i < str2.length(); i++) {
            ch = str2.charAt(i);
            if (hashMap.get(ch) == null) {
                return false;
            } else {
                hashMap.put(ch, hashMap.get(ch) - 1);
            }
        }

        return hashMap.values().stream().allMatch(integer -> integer == 0);
    }
}

package com.ctci.arrays_strings;

/* Checking the given string is a permutation of a palindrome */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromePermutation {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter String: ");
        String str = br.readLine();
        if (isPermutationOfPalindrome(str.toLowerCase().replaceAll(" ", ""))) {
            System.out.println(str + " is a permutation of a palindrome");
        } else {
            System.out.println(str + " is not a permutation of a palindrome");
        }
    }

    private static boolean isPermutationOfPalindrome(String str) {
        int bitVector = calculateBitVector(str);
        return (bitVector == 0) || ((bitVector & (bitVector - 1)) == 0);
    }

    private static int calculateBitVector(String str) {
        int bitVector = 0;
        for (char ch : str.toCharArray()) {
            int charPosition = ch - 'a';
            int mask = 1 << charPosition;
            if ((bitVector & mask) == 0) {
                bitVector |= mask;
            } else {
                bitVector &= ~mask;
            }
        }

        return bitVector;
    }
}

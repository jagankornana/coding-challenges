package com.hackerearth.datastructures.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveDuplicates {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] mask = new boolean[26];
        StringBuilder str = new StringBuilder(br.readLine());
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!mask[ch - 'a']) {
                System.out.print(ch);
                mask[ch - 'a'] = true;
            }

            if (checkMask(mask)) {
                break;
            }
        }
    }

    private static boolean checkMask(boolean[] mask) {
        for (boolean aMask : mask) {
            if (!aMask) {
                return false;
            }
        }
        return true;
    }
}

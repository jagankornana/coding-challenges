package com.ctci.arrays_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Compress the given string aaabbb -> a3b3 */

public class StringCompressor {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter String:");
        String str = br.readLine();
        System.out.println("Compressed String: " + getCompressedString(str));
    }

    private static String getCompressedString(String str) {
        StringBuilder sb = new StringBuilder();
        int charCount = 0;
        for (int i = 0; i < str.length(); i++) {
            charCount++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                sb.append(str.charAt(i));
                sb.append(charCount);
                charCount = 0;
            }
        }
        return sb.length() <= str.length() ? sb.toString() : str;
    }
}

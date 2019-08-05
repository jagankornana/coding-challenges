package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChanduAndConsecutiveLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); ) {
                char ch = str.charAt(j++);
                System.out.print(ch);
                if (j < str.length()) {
                    while (str.charAt(j) == ch) {
                        j++;
                        if (j >= str.length())
                            break;
                    }
                }
            }
            System.out.println();
        }
    }
}

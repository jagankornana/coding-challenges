package com.hackerearth.datastructures.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountEnemies {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < t; testCase++) {
            StringBuilder str = new StringBuilder(br.readLine());

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'X') {
                    killEnemy(i, str);
                }
            }

            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'O') {
                    count++;
                }
            }

            System.out.println(count);
        }
    }

    private static void killEnemy(int i, StringBuilder str) {
        int j = i - 1;
        while (j >= 0) {
            char ch = str.charAt(j);
            if (ch == 'O') {
                str.setCharAt(j, '\u0000');
            } else if (ch == '*' || ch == 'X') {
                break;
            }
            j--;
        }

        j = i + 1;
        while (j < str.length()) {
            char ch = str.charAt(j);
            if (ch == 'O') {
                str.setCharAt(j, '\u0000');
            } else if (ch == '*' || ch == 'X') {
                break;
            }
            j++;
        }
    }
}

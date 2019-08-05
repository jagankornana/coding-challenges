package com.hackerearth.competitions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstRepeatingChar {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the input string	: ");
        String str = br.readLine();

        boolean flag = true;
        for (int i = 0; i < str.length() - 1; i++) {
            char ch = str.charAt(i);
            if (str.indexOf(ch, i + 1) != -1) {
                System.out.println("First repeating char	: " + ch);
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("There is no repeating character in the given input string.");
        }
    }
}

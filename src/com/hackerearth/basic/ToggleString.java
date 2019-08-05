package com.hackerearth.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ToggleString {

    public static void main(String[] args) throws IOException, NumberFormatException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 97 && ch <= 122)
                System.out.print((char) (ch - 32));
            else if (ch >= 65 && ch <= 90)
                System.out.print((char) (ch + 32));
        }
    }
}

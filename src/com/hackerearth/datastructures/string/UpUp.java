package com.hackerearth.datastructures.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpUp {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ch;
        boolean flag = true;
        while (true) {
            ch = br.read();
            if (ch == -1) {
                break;
            }

            if ((char) ch == ' ') {
                System.out.print(Character.toChars(ch));
                flag = true;
            } else if (flag) {
                if (ch >= 97 && ch <= 122) {
                    System.out.print(Character.toChars(ch - 32));
                } else {
                    System.out.print(Character.toChars(ch));
                }
                flag = false;
            } else {
                System.out.print(Character.toChars(ch));
            }
        }
    }
}

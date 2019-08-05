package com.hackerearth.datastructures.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompilerVersion {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while (((str = br.readLine()) != null) && str.length() != 0) {
            if (str.contains("//")) {
                System.out.println(str.substring(0, str.indexOf("//")).replace("->", ".") + str.substring(str.indexOf("//")));
            } else {
                System.out.println(str.replace("->", "."));
            }
        }
    }
}

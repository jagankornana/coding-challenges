package com.hackerrank.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DupWordsRegEx {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(
                System.in));
        Pattern p = Pattern.compile("\\b(\\w+)\\b\\s*\\b\\1\\b", Pattern.CASE_INSENSITIVE);
        String str = input.readLine();
        Matcher m = p.matcher(str);
        while (m.find()) {
            str = str.replaceAll(m.group(), m.group(1));
            m = p.matcher(str);
        }

        System.out.println(str);
    }
}

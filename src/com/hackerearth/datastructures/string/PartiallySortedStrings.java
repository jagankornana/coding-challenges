package com.hackerearth.datastructures.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class PartiallySortedStrings {

    public static int m;
    private static Comparator<String> partialComparator = new Comparator<String>() {

        @Override
        public int compare(String str1, String str2) {
            return str1.substring(0, m).compareTo(str2.substring(0, m));
        }
    };

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < t; testCase++) {
            String[] strings = br.readLine().split(" ");
            int n = Integer.parseInt(strings[0]);
            int k = Integer.parseInt(strings[1]);
            m = Integer.parseInt(strings[2]);
            strings = new String[n];
            for (int i = 0; i < strings.length; i++) {
                strings[i] = br.readLine();
            }

            Arrays.sort(strings, partialComparator);

            System.out.println(strings[k - 1]);
        }
    }
}

package com.hackerearth.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagrams {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str1 = br.readLine();
            String str2 = br.readLine();
            int numOfDeletions = findNumOfDel(str1, str2);
            System.out.println(numOfDeletions);
        }
    }

    private static int findNumOfDel(String str1, String str2) {
        int[] arr1 = getCharCount(str1);
        int[] arr2 = getCharCount(str2);
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            count += Math.abs(arr1[i] - arr2[i]);
        }
        return count;
    }

    private static int[] getCharCount(String str) {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a'] += 1;
        }
        return arr;
    }
}

package com.hackerearth.datastructures.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class StringDivision {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < t; testCase++) {
            String str = br.readLine();

            boolean flag = true;
            outer:
            for (int i = 1; i <= str.length() - 3; i++) {
                for (int j = i + 1; j <= str.length() - 2; j++) {
                    for (int k = j + 1; k <= str.length() - 1; k++) {
                        if (canSplit(i, j, k, str)) {
                            System.out.println("YES");
                            flag = false;
                            break outer;
                        }
                    }
                }
            }
            if (flag) {
                System.out.println("NO");
            }
        }
    }

    private static boolean canSplit(int i, int j, int k, String str) {
        HashSet<String> set = new HashSet<>();
        return set.add(str.substring(0, i)) && set.add(str.substring(i, j)) && set.add(str.substring(j, k))
                && set.add(str.substring(k));
    }
}

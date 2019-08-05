package com.hackerearth.datastructures.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class SumitAndRohil {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = br.readLine();
        }

        ArrayList<String> groups = new ArrayList<>();
        groups.add(names[0]);
        for (int i = 1; i < names.length; i++) {
            boolean flag = true;
            for (String group : groups) {
                if (areSameGroup(names[i], group)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                groups.add(names[i]);
            }
        }

        System.out.println(groups.size());
    }

    private static boolean areSameGroup(String name1, String name2) {
        if (name1.length() != name2.length()) {
            return false;
        } else if (name1.charAt(0) != name2.charAt(0)) {
            return false;
        } else if (name1.charAt(name1.length() - 1) != name2.charAt(name2.length() - 1)) {
            return false;
        } else {
            char[] name1Arr = name1.substring(1, name1.length() - 1).toCharArray();
            char[] name2Arr = name2.substring(1, name2.length() - 1).toCharArray();
            Arrays.sort(name1Arr);
            Arrays.sort(name2Arr);
            for (int i = 0; i < name1Arr.length; i++) {
                if (name1Arr[i] != name2Arr[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}

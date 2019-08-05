package com.hackerearth.datastructures.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ModifySequence {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strings = br.readLine().split(" ");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(strings[i]);
        }

        if (n == 1) {
            if (array[0] == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            int result = array[n - 2] - array[n - 1];
            boolean flag = true;
            if (result < 0) {
                System.out.println("NO");
                flag = false;
            } else {
                for (int i = n - 3; i >= 0; i--) {
                    result = array[i] - result;
                    if (result < 0) {
                        System.out.println("NO");
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                if (result == 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}

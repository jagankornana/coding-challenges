package com.hackerearth.datastructures.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IDemandTrialByCombat {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < t; testCase++) {
            String[] strings = br.readLine().split(" ");
            int n = Integer.parseInt(strings[0]);
            int m = Integer.parseInt(strings[1]);
            strings = br.readLine().split(" ");
            int[] lannisters = new int[n];
            for (int i = 0; i < n; i++) {
                lannisters[i] = Integer.parseInt(strings[i]);
            }

            for (int i = 0; i < m; i++) {
                int[] lannistersNxtHr = new int[n];
                if (lannisters[1] == 1) {
                    lannistersNxtHr[0] = 1;
                } else {
                    lannistersNxtHr[0] = 0;
                }

                if (lannisters[n - 2] == 1) {
                    lannistersNxtHr[n - 1] = 1;
                } else {
                    lannistersNxtHr[n - 1] = 0;
                }

                for (int j = 1; j <= n - 2; j++) {
                    lannistersNxtHr[j] = lannisters[j - 1] & lannisters[j + 1];
                }
                lannisters = lannistersNxtHr;
                if (checkLannisters(lannisters)) {
                    break;
                }
            }

            for (int lannister : lannisters) {
                System.out.print(lannister + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkLannisters(int[] lannisters) {
        int result = 1;
        boolean flag = true;
        for (int lannister : lannisters) {
            result &= lannister;
            if (result == 0) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return true;
        } else {
            result = 0;
            flag = true;
            for (int lannister : lannisters) {
                result |= lannister;
                if (result == 1) {
                    flag = false;
                    break;
                }
            }
            return flag;
        }
    }
}

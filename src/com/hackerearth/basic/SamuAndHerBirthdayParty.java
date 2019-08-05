package com.hackerearth.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SamuAndHerBirthdayParty {

    private static String[] dishPreparance;
    private static int[][] dpState;

    private static void initialize() {
        dpState = new int[500][1 << 10];
        for (int[] aDpState : dpState) {
            Arrays.fill(aDpState, -1);
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < t; testCase++) {
            String[] strings = br.readLine().split(" ");
            int n = Integer.parseInt(strings[0]);
            Integer.parseInt(strings[1]);

            dishPreparance = new String[n];
            for (int i = 0; i < n; i++) {
                dishPreparance[i] = br.readLine();
            }

            initialize();

            int minNumOfOrders = minDishOrdersRec(0, 0);

            System.out.println(minNumOfOrders);
        }
    }

    private static int minDishOrdersRec(int frndIndex, int mask) {

        if (frndIndex == dishPreparance.length) {
            return 0;
        }

        int state = dpState[frndIndex][mask];
        if (state != -1) {
            return state;
        }

        int ans = 100000000;
        for (int j = 0; j < dishPreparance[frndIndex].length(); j++) {
            char ch = dishPreparance[frndIndex].charAt(j);
            if (ch != '0') {
                if ((mask & (1 << j)) > 0) {
                    ans = Math.min(ans, minDishOrdersRec(frndIndex + 1, mask));
                } else {
                    ans = Math.min(ans, 1 + minDishOrdersRec(frndIndex + 1, (mask | (1 << j))));
                }
            }
        }

        dpState[frndIndex][mask] = ans;
        return ans;
    }

}

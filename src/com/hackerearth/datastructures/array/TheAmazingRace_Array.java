package com.hackerearth.datastructures.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheAmazingRace_Array {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            String[] strings = br.readLine().split(" ");
            int[] vehicleHeights = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                vehicleHeights[i] = Integer.parseInt(strings[i - 1]);

            }

            if (n == 1) {
                System.out.println("1");
                continue;
            }

            long maxSight = 0;
            int maxSightIndex = 0;
            int i = n - 1;
            int j = n;
            int curVehIndex = n;
            while (i != curVehIndex) {
                if (vehicleHeights[i] < vehicleHeights[curVehIndex] && i > 1) {
                    i--;
                } else {
                    long seeFront;
                    if (curVehIndex == 1) {
                        seeFront = 0;
                    } else {
                        seeFront = curVehIndex - i;
                    }
                    long seeBehind;
                    if (curVehIndex == n) {
                        seeBehind = 0;
                    } else {
                        if (vehicleHeights[curVehIndex] == vehicleHeights[j] || i == 0) {
                            seeBehind = j - curVehIndex;
                        } else {
                            seeBehind = n - curVehIndex;
                        }

                    }

                    long sight = (((seeFront + seeBehind) % 1000000007) * curVehIndex) % 1000000007;
                    if (sight >= maxSight) {
                        maxSight = sight;
                        maxSightIndex = curVehIndex;
                    }

                    j = curVehIndex;
                    curVehIndex = i;
                    if (i > 0) {
                        i--;
                    }
                }
            }

            System.out.println(maxSightIndex);
        }
    }
}

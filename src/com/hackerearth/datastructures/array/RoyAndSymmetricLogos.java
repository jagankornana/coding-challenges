package com.hackerearth.datastructures.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoyAndSymmetricLogos {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            String[] logoMatrix = new String[n];
            for (int i = 0; i < n; i++) {
                logoMatrix[i] = br.readLine();
            }

            boolean flag = true;
            for (int i = 0; i <= (n - 1) / 2; i++) {
                for (int j = 0; j <= (n - 1) / 2; j++) {
                    if ((logoMatrix[i].charAt(j) != logoMatrix[i].charAt(n - 1 - j))
                            || (logoMatrix[i].charAt(j) != logoMatrix[n - 1 - i].charAt(j))
                            || (logoMatrix[i].charAt(j) != logoMatrix[n - 1 - i].charAt(n - 1 - j))) {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

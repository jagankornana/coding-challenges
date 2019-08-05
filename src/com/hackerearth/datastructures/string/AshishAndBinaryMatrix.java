package com.hackerearth.datastructures.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AshishAndBinaryMatrix {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < t; testCase++) {
            String[] inputData = br.readLine().split(" ");
            int n = Integer.parseInt(inputData[0]);
            int m = Integer.parseInt(inputData[1]);

            String[] binaryMatrix = new String[n];
            for (int i = 0; i < binaryMatrix.length; i++) {
                binaryMatrix[i] = br.readLine();
            }

            if (areUniqueStrings(binaryMatrix)) {
                boolean flag = true;
                Set<String> set;
                for (int i = 0; i < m; i++) {
                    set = new HashSet<>();
                    for (int j = 0; j < n; j++) {
                        if (i == 0) {
                            set.add(binaryMatrix[j].substring(1));
                        } else if (i == m - 1) {
                            set.add(binaryMatrix[j].substring(0, i));
                        } else {
                            set.add(binaryMatrix[j].substring(0, i) + binaryMatrix[j].substring(i + 1));
                        }
                    }
                    if (set.size() == binaryMatrix.length) {
                        System.out.println("Yes");
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println("No");
                }
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean areUniqueStrings(String[] binaryMatrix) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, binaryMatrix);
        return set.size() == binaryMatrix.length;
    }
}

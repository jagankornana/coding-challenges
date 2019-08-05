package com.hackerearth.competitions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Dual_Issues {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            String[] strings = br.readLine().split(" ");
            int[] array = new int[n];
            TreeSet<Integer> primeNums = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(strings[i]);
                if (!primeNums.contains(array[i]) && isPrimeNum(array[i])) {
                    primeNums.add(array[i]);
                }
            }

            if (primeNums.size() == 0) {
                System.out.println("-1");
            } else {
                System.out.println(primeNums.last() * primeNums.last());
            }
        }
    }

    private static boolean isPrimeNum(int num) {
        if (num <= 1)
            return false;
        if (num == 2)
            return true;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}

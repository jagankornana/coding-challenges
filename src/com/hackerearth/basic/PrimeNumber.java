package com.hackerearth.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        printPrimes(number);
    }

    private static void printPrimes(int number) {
        if (2 <= number) {
            System.out.print("2");
        }
        for (int i = 3; i <= number; i += 2) {
            if (isPrime(i)) {
                System.out.print(" " + i);
            }
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}

package com.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeNumber {

    private static void isPrimeNumber(int num) {

        boolean flag = true;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                System.out.println("Not Prime Number. Divisor is " + i);
                flag = false;
                break;
            }
        }
        if (flag)
            System.out.println("Prime Number.");
    }

    private static void printPrimeNums(int range) {
        boolean[] primeArray = new boolean[range + 1];
        Arrays.fill(primeArray, true);
        for (int i = 2; i * i <= range; i++) {
            for (int j = i * 2; j <= range; j += i) {
                primeArray[j] = false;
            }
        }
        for (int i = 2; i <= range; i++) {
            if (primeArray[i])
                System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        isPrimeNumber(num);
        printPrimeNums(num);
        sc.close();
    }
}

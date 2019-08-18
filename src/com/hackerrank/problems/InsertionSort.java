package com.hackerrank.problems;

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numArray = new int[n];
        for (int i = 0; i < n; i++)
            numArray[i] = sc.nextInt();
        int lastElement = numArray[n - 1];
        if (n == 1)
            System.out.println(numArray[0]);
        else {
            int i = n - 2;
            while (i >= 0 && numArray[i] > lastElement) {
                numArray[i + 1] = numArray[i];
                for (int j = 0; j < n; j++)
                    System.out.print(numArray[j] + " ");
                System.out.println();
                i--;
            }
            numArray[i + 1] = lastElement;
            for (int j = 0; j < n; j++)
                System.out.print(numArray[j] + " ");
        }
        sc.close();
    }
}

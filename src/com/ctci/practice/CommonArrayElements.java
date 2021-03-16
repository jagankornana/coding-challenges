package com.ctci.practice;

import java.util.Scanner;

/*To find common elements in the given two sorted arrays*/

public class CommonArrayElements {

    public static void main(String[] args) {
        int limit;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the array size: ");
        limit = scanner.nextInt();
        int[] array1 = new int[limit];
        int[] array2 = new int[limit];
        System.out.println("Enter array1 elements:");
        for (int i = 0; i < limit; i++) {
            array1[i] = scanner.nextInt();
        }
        System.out.println("Enter array2 elements:");
        for (int i = 0; i < limit; i++) {
            array2[i] = scanner.nextInt();
        }

        System.out.println("Common elements:");
        int i = 0, j = 0;
        while (i < limit && j < limit) {
            if (array1[i] == array2[j]) {
                System.out.println(array1[i]);
                i++;
                j++;
            } else if (array1[i] < array2[j]) {
                i++;
            } else {
                j++;
            }
        }
    }
}

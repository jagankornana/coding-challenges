package com.hackerrank.java;

import java.util.Scanner;

public class JavaLoops {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[][] array = new int[t][3];
		for (int i = 0; i < t; i++) {
			for (int j = 0; j < 3; j++) {
				array[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < t; i++) {
			int sum = array[i][0] + ((int) (Math.pow(2, 0) * array[i][1]));
			System.out.print(sum);
			for (int j = 1; j < array[i][2]; j++) {
				sum += (int) (Math.pow(2, j)) * array[i][1];
				System.out.print(" " + sum);
			}
			System.out.println();
		}
		sc.close();
	}
}

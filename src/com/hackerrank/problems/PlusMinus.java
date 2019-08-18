package com.hackerrank.problems;

import java.util.Scanner;

public class PlusMinus {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		float positiveNums = 0, negativeNums = 0, zeros = 0;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] > 0) {
				positiveNums += 1;
			} else if (arr[i] < 0) {
				negativeNums += 1;
			} else {
				zeros += 1;
			}
		}
		System.out.println(String.format("%.6f", positiveNums / n));
		System.out.println(String.format("%.6f", negativeNums / n));
		System.out.println(String.format("%.6f", zeros / n));
		sc.close();
	}
}

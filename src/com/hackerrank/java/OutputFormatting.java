package com.hackerrank.java;

import java.util.Scanner;

public class OutputFormatting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] strings = new String[3];
		int[] nums = new int[3];
		for (int i = 0; i < 3; i++) {
			strings[i] = sc.next();
			nums[i] = sc.nextInt();
		}
		System.out.println("================================");
		for (int i = 0; i < 3; i++) {
			System.out.printf("%-15s", strings[i]);
			System.out.printf("%03d", nums[i]);
			System.out.println();
		}
		System.out.println("================================");
		sc.close();
	}
}

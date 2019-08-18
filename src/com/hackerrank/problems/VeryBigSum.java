package com.hackerrank.problems;

import java.math.BigInteger;
import java.util.Scanner;

public class VeryBigSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BigInteger[] bArray = new BigInteger[n];
		for (int i = 0; i < n; i++) {
			bArray[i] = sc.nextBigInteger();
		}
		BigInteger sumOfNumbers = new BigInteger("0");
		for (int i = 0; i < n; i++) {
			sumOfNumbers = sumOfNumbers.add(bArray[i]);
		}
		System.out.println(sumOfNumbers);
		sc.close();
	}
}

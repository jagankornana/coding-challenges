package com.hackerrank.problems;

import java.util.Scanner;

public class SolveMeFirst {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Number a, b, c;
		a = sc.nextBigInteger();
		b = sc.nextBigInteger();
		c = sum(a, b);
		System.out.println(c);
		sc.close();
	}

	public static Number sum(Number a, Number b) {
		return a.longValue() + b.longValue();
	}
}

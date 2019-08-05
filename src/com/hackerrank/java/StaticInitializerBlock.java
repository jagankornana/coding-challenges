package com.hackerrank.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StaticInitializerBlock {

	public static int BREADTH = initializeBreadth();

	private static int initializeBreadth() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int b = 0;
		try {
			b = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		return b;
	}

	public static int HEIGHT = initializeHeight();

	private static int initializeHeight() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int h = 0;
		try {
			h = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		return h;
	}

	public static void main(String[] args) {
		System.out.println(BREADTH * HEIGHT);
	}
}
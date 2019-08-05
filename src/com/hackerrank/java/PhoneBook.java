package com.hackerrank.java;

import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashMap<String, Integer> phoneBook = new HashMap<String, Integer>();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String name = sc.nextLine();
			int phone = sc.nextInt();
			sc.nextLine();
			phoneBook.put(name, phone);
		}
		while (sc.hasNext()) {
			String str = sc.nextLine();
			if (phoneBook.containsKey(str)) {
				System.out.println(str + "=" + phoneBook.get(str));
			}
			else
				System.out.println("Not found");
		}
		sc.close();
	}
}
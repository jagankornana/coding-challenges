package com.ctci.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*To generate permutations of the given string*/

public class PermutationsOfAString {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		permutation(str);
	}

	private static void permutation(String str) {
		permutation(str, "");
	}

	private static void permutation(String str, String prefix) {
		if (str.length() == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < str.length(); i++) {
				String rem = str.substring(0, i) + str.substring(i + 1);
				permutation(rem, prefix + str.charAt(i));
			}
		}
	}
}

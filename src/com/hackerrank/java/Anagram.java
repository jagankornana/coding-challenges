package com.hackerrank.java;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
	
	public static void isAnagram(String str1, String str2){
		
		char[] charArray1 = null;
		charArray1=str1.toCharArray();
//		System.out.println(charArray1);
		
		char[] charArray2 = null;
		charArray2=str2.toCharArray();
//		System.out.println(charArray2);
		
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);
		
		str1=new String(charArray1);
		str2=new String(charArray2);
		
		if(str1.equals(str2))
			System.out.println("Anagrams");
		else
			System.out.println("Not Anagrams");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		isAnagram(str1.toLowerCase(), str2.toLowerCase());
		sc.close();
	}
}

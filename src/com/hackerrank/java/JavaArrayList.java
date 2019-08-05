package com.hackerrank.java;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class JavaArrayList {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		ArrayList<String> intArrays = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			intArrays.add(sc.nextLine());
		}
		
		StringTokenizer st;
		int numOfQueries = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < numOfQueries; i++) {
			st = new StringTokenizer(sc.nextLine(), " ");
			try{
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				st = new StringTokenizer(intArrays.get(x-1), " ");
				st.nextToken();
		
				for(int tokenNum=1;tokenNum<y;tokenNum++)
					st.nextToken();
				System.out.println(st.nextToken());
			}
			catch(NoSuchElementException e){
				System.out.println("ERROR!");
			}
		}
		sc.close();
	}
}
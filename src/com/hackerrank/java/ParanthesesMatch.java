package com.hackerrank.java;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class ParanthesesMatch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack;
		while(sc.hasNext()){
			stack = new Stack<Character>();
			boolean flag=true;
			String str=sc.next();
			char[] charArray=str.toCharArray();
			for(int i=0;i<charArray.length;i++){
				if(charArray[i]=='(' || charArray[i]=='{' || charArray[i]=='[')
					stack.push(charArray[i]);
				else if(charArray[i]==')' || charArray[i]=='}' || charArray[i]==']')
					try {
						stack.pop();
					} catch (EmptyStackException e) {
						System.out.println("false");
						flag=false;
						break;
					}
				//System.out.println(stack.toString());
			}
			if(flag){
				if(stack.isEmpty())
					System.out.println("true");
				else
					System.out.println("false");
			}
		}
		sc.close();
	}
}
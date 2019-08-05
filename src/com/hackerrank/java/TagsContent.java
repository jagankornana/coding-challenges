package com.hackerrank.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagsContent {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] userNames = new String[n];
		for (int i = 0; i < n; i++) {
			userNames[i] = br.readLine();
		}
		
		Pattern p = Pattern.compile("(^\\<([\\w]+[\\w\\s]*\\>)([\\w\\s]*)\\<\\/\\2)|(\\<([\\w]+[\\w\\s]*\\>)([\\w\\s]*)\\<\\/\\5)+");
		for (int i = 0; i < userNames.length; i++) {
			Matcher m = p.matcher(userNames[i]);
			if(!m.find()){
				System.out.println("None");
			}
			else{
				m = p.matcher(userNames[i]);
				while(m.find()){
					if(m.group(3) != null){
						if(m.group(3).length()>0)
							System.out.println(m.group(3));
						else
							System.out.println("None");
					}
					else if(m.group(6) != null){
						if(m.group(6).length()>0)
							System.out.println(m.group(6));
						else
							System.out.println("None");
					}
				}
			}
		}
	}
}
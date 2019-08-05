package com.hackerrank.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Checker implements Comparator<Player>{

	@Override
	public int compare(Player a, Player b) {
		if(a.score<b.score)
			return 1;
		else if(a.score>b.score)
			return -1;
		else{
			if(a.name.compareTo(b.name)<0)
				return -1;
			else if(a.name.compareTo(b.name)>0)
				return 1;
			else
				return 0;
		}
	}
	
}

class Player {
	public String name;
	public int score;

	public Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

public class ComparatorEx {
	public static void main(String[] args) {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		Player[] players = new Player[n];
		Checker check = new Checker();
		
		for(int i=0;i<n;i++){
			players[i]=new Player(sc.next(),sc.nextInt());
		}
		sc.close();
		
		Arrays.sort(players, check);
		
		for(int i=0;i<n;i++){
			System.out.println(players[i].name+ " "+ players[i].score);
		}
	}
}
package com.hackerrank.java;

public class HelloThread extends Thread {
	
	public void run() {
		System.out.println("Hello from a thread class!!");
	}

	public static void main(String[] args) {
		/*HelloThread thread=new HelloThread();
		thread.run();*/
		new HelloThread().start();
	}
}

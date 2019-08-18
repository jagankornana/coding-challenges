package com.hackerrank.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Game_BackTracking {
	/*public static int position;
	public static boolean flag;

	public static void forward() {
		position++;
	}

	public static void backward() {
		position--;
		flag = true;
	}

	public static void jump(int jumpLength) {
		position += jumpLength;
		flag = false;
	}*/

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfTestCases = Integer.parseInt(br.readLine());
		String[] ansArray = new String[numOfTestCases];

		for (int i = 0; i < numOfTestCases; i++) {
			int position = 0;
			boolean flag = false;

			StringTokenizer st = new StringTokenizer(br.readLine(), " ", false);
			int arraySize = Integer.parseInt(st.nextToken());
			int jumpLength = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ", false);
			String[] nums = new String[arraySize];
			for (int j = 0; st.hasMoreTokens(); j++) {
				nums[j] = st.nextToken();
			}

			while (true) {
				int tempPosition = position;

				if (position + 1 >= arraySize || position + jumpLength >= arraySize) {
					ansArray[i] = "YES";
					break;
				} else if (nums[position + 1].equals("0") && (!flag)) {
					position++;
				} else if (nums[position + jumpLength].equals("0")) {
					position += jumpLength;
					flag = false;
				} else if (position > 0 && nums[position - 1].equals("0")) {
					position--;
					flag = true;
				}

				if (position == tempPosition || (position == 0 && nums[position + jumpLength].equals("1"))) {
					ansArray[i] = "NO";
					break;
				}
			}
		}

		for (String s : ansArray) {
			System.out.println(s);
		}
	}
}
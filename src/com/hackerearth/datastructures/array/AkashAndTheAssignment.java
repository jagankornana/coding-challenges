package com.hackerearth.datastructures.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AkashAndTheAssignment {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        //int n = Integer.parseInt(nums[0]);
        int q = Integer.parseInt(nums[1]);
        String str = br.readLine();
        for (int query = 0; query < q; query++) {
            String[] strings = br.readLine().split(" ");
            int l = Integer.parseInt(strings[0]);
            int r = Integer.parseInt(strings[1]);
            int k = Integer.parseInt(strings[2]);

            if ((r - l + 1) < k) {
                System.out.println("Out of range");
                continue;
            }

            int[] charCount = new int[26];
            for (int i = l - 1; i < r; i++) {
                charCount[str.charAt(i) - 'a'] += 1;
            }

            int count = 0;
            for (int i = 0; i < charCount.length; i++) {
                count += charCount[i];
                if (count >= k) {
                    System.out.println((char) ('a' + i));
                    break;
                }
            }
        }
    }
}

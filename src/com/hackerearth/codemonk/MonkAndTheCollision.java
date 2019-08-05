package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MonkAndTheCollision {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] hashTable = new int[10];
            Arrays.fill(hashTable, -1);
            st = new StringTokenizer(br.readLine(), " ");
            int collisions = 0;
            for (int j = 0; j < n; j++) {
                int hashIndex = Integer.parseInt(st.nextToken()) % 10;
                if (hashTable[hashIndex] == -1)
                    hashTable[hashIndex] = 1;
                else
                    collisions++;
            }
            System.out.println(collisions);
        }
    }
}

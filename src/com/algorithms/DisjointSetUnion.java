package com.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DisjointSetUnion {

    private static int[] array;

    private static void initialize(int n) {
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
    }

    private static int root(int i) {
        while (array[i] != i) {
            i = array[i];
        }
        return i;
    }

    private static void union(int a, int b) {
        int rootA = root(a);
        int rootB = root(b);

        array[rootA] = rootB;
    }

    private static void find(int a, int b) {
        int rootA = root(a);
        int rootB = root(b);
        if (rootA == rootB)
            System.out.println("(" + a + "," + b + ") connected.");
        else
            System.out.println("(" + a + "," + b + ") not connected.");
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter num of nodes: ");
        int n = Integer.parseInt(br.readLine());
        initialize(n);
        union(1, 0);
        union(0, 2);
        union(3, 4);
        union(1, 4);
        find(1, 4);
        find(3, 5);
    }
}

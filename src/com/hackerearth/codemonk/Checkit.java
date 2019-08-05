package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Checkit {

    public static int[] array;

    private static void disjointSetUnion(int vertices) {
        array = new int[vertices + 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    private static int root(int index) {
        while (array[index] != index) {
            index = array[array[index]];
        }
        return index;
    }

    private static void union(int x, int y) {
        int rootX = root(x);
        int rootY = root(y);
        array[rootX] = rootY;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            disjointSetUnion(n);
            int[][] edges = new int[m + 1][2];
            for (int j = 1; j <= m; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                edges[j][0] = Integer.parseInt(st.nextToken());
                edges[j][1] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            boolean flag = true;
            while (st.hasMoreTokens()) {
                int index = Integer.parseInt(st.nextToken());
                int x = edges[index][0];
                int y = edges[index][1];
                if (root(x) != root(y)) {
                    union(x, y);
                } else {
                    System.out.println("NO");
                    flag = false;
                    break;
                }

            }
            if (flag) {
                int count = 0;
                for (int j = 1; j < array.length; j++) {
                    if (array[j] == j) {
                        count++;
                    }
                }
                if (count == 1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}

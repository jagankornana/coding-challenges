package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CityAndFlood {

    private static int[] array;

    private static void initialize(int n) {
        array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = i;
        }
    }

    private static int root(int i) {
        while (array[i] != i) {
            i = array[i];
        }
        return i;
    }

    private static void empire(int a, int b) {
        int rootA = root(a);
        int rootB = root(b);
        array[rootB] = rootA;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k;
        if (st.hasMoreTokens())
            k = Integer.parseInt(st.nextToken());
        else
            k = Integer.parseInt(br.readLine());

        initialize(n);

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            empire(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int components = 0;
        for (int i = 1; i <= n; i++) {
            if (array[i] == i)
                components++;
        }
        System.out.println(components);
    }
}

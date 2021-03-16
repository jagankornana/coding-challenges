package com.ctci.bits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Insertion {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m, n, i, j;
        System.out.print("Enter N: ");
        n = Integer.parseInt(br.readLine(), 2);
        System.out.print("Enter M: ");
        m = Integer.parseInt(br.readLine(), 2);
        System.out.print("Enter i: ");
        i = Integer.parseInt(br.readLine());
        System.out.print("Enter j: ");
        j = Integer.parseInt(br.readLine());

        int output = insertMIntoN(m, n, i, j);
        System.out.println("Output: " + Integer.toBinaryString(output));
    }

    private static int insertMIntoN(int m, int n, int i, int j) {
        while (m > 0 && i <= j) {
            int bitFromM = m & 1;
            n = (n & ~(1 << i)) | (bitFromM << i);
            i++;
            m >>= 1;
        }

        return n;
    }
}

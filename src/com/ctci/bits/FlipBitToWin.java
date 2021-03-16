package com.ctci.bits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlipBitToWin {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number: ");
        int num = Integer.parseInt(br.readLine());
        int i, j, max;
        boolean flipBit = false;
        max = i = j = 0;
        while (num > 0) {
            int bit = num & 1;
            if (bit == 1) {
                i++;
                if (flipBit) {
                    j++;
                }
            } else {
                if (flipBit) {
                    if (i > max) {
                        max = i;
                    }
                    i = j;
                    j = 0;
                }
                flipBit = true;
                i++;
            }
            num >>= 1;
        }
        if (i > max) {
            max = i;
        }
        System.out.println("Max 1s sequence length: " + max);
    }
}

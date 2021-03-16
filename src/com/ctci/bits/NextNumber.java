package com.ctci.bits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NextNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number: ");
        int num = Integer.parseInt(br.readLine());
        System.out.println("Next largest number : " + findNextLargestNum(num));
        System.out.println("Next smallest number: " + findNextSmallestNum(num));
    }

    private static int findNextLargestNum(int num) {
        // 101011
        int i = -1;
        int onesCount = 0;
        boolean flag = false;
        while (true) {
            i++;
            if ((num & (1 << i)) > 0) {
                flag = true;
                onesCount++;
            } else {
                if (flag) {
                    break;
                }
            }
        }
        num = num | (1 << i);
        num = num & (-1 << i);
        num = num | ((1 << (onesCount - 1)) - 1);

        return num;
    }

    private static int findNextSmallestNum(int num) {
        //100011
        int i = -1;
        int onesCount = 0;
        boolean flag = false;
        while (true) {
            i++;
            if ((num & (1 << i)) > 0) {
                onesCount++;
                if (flag) {
                    break;
                }
            } else {
                flag = true;
            }
        }
        num = num & ~(1 << i);
        num = num & (-1 << i);
        num = num | ((1 << onesCount) - 1) << (i - onesCount);

        return num;
    }
}

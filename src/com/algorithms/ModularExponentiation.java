package com.algorithms;

import java.util.Scanner;

public class ModularExponentiation {

    private static long modularExponentiationIterate(long a, long b, long c) {
        long ans = 1;
        while (b != 0) {
            if (b % 2 == 1) {
                ans *= a;
                ans %= c;
            }
            a = a * a;
            a %= c;
            b /= 2;
        }
        return ans;
    }

    private static long modularExponentiationRecursion(long a, long b, long c) {
        if (b == 0)
            return 1;
        else if (b == 1)
            return a % c;
        else if (b % 2 == 0) {
            return modularExponentiationRecursion((a * a) % c, b / 2, c);
        } else
            return (a * modularExponentiationRecursion((a * a) % c, (b - 1) / 2, c)) % c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = 1000000007;
        System.out.println(modularExponentiationIterate(a, b, c));
        System.out.println(modularExponentiationRecursion(a, b, c));
        sc.close();
    }
}

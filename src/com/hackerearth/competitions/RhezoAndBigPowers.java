package com.hackerearth.competitions;

import java.math.BigInteger;
import java.util.Scanner;

public class RhezoAndBigPowers {

    private static BigInteger modularExponentiationIterate(BigInteger a, BigInteger b, BigInteger c) {
        BigInteger ans = BigInteger.ONE;
        String bits = b.toString(2);
        for (int i = bits.length() - 1; i >= 0; i--) {
            if (bits.charAt(i) == '1') {
                ans = ans.multiply(a);
                ans = ans.remainder(c);
            }
            a = a.multiply(a);
            a = a.remainder(c);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = new BigInteger(sc.nextLine());
        BigInteger b = new BigInteger(sc.nextLine());
        BigInteger c = new BigInteger("1000000007");
        System.out.println(modularExponentiationIterate(a, b, c));
        sc.close();
    }
}

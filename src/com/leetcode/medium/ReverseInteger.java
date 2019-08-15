package com.leetcode.medium;

public class ReverseInteger {

    public static void main(String[] args) {
        // -2,147,483,648 to 2,147,483, 647
        System.out.println(reverse(239486234));
        System.out.println(reverse(432684932));
        System.out.println(reverse(2147483647));
        System.out.println(reverse(-2147483648));

    }

    private static int reverse(int x) {
        long rev = 0;
        while (x != 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        if (rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE) return 0;
        return (int) rev;
    }
}

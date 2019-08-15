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
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        boolean negative = x < 0;
        String str = String.valueOf(Math.abs(x));
        int len = str.length();
        char[] charArr = new char[len];
        for (int i = len - 1; i >= 0; i--) {
            charArr[len - i - 1] = str.charAt(i);
        }
        long rev = Long.valueOf(new String(charArr));

        if (negative) {
            rev = 0 - rev;
            if (rev < Integer.MIN_VALUE) {
                return 0;
            }
            return (int) rev;
        } else {
            if (rev > Integer.MAX_VALUE) {
                return 0;
            }
        }
        return (int) rev;
    }
}

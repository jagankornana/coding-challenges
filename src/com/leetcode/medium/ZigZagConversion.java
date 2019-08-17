package com.leetcode.medium;

public class ZigZagConversion {

    public static void main(String[] args) {
        ZigZagConversion zigZag = new ZigZagConversion();
        System.out.println(zigZag.convert("PAYPALISHIRING", 1));
        System.out.println(zigZag.convert("PAYPALISHIRING", 2));
        System.out.println(zigZag.convert("PAYPALISHIRING", 3));
        System.out.println(zigZag.convert("PAYPALISHIRING", 4));
        System.out.println(zigZag.convert("PAYPALISHIRING", 5));
        System.out.println(zigZag.convert("PAYPALISHIRING", 6));
        System.out.println(zigZag.convert("PAYPALISHIRING", 13));

    }

    private String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int len = s.length(), curIdx = 0, nxtChIdx = (2 * numRows) - 2;
        char[] res = new char[len];
        for (int i = 0; i < numRows; i++) {
            int j = i;
            while (true) {
                if (j >= numRows && (j - 2 * i) < len && i > 0 && i < (numRows - 1)) {
                    res[curIdx++] = s.charAt(j - 2 * i);
                }
                if (j >= len) break;
                res[curIdx++] = s.charAt(j);
                j = j + nxtChIdx;
            }
        }
        return String.valueOf(res);
    }
}

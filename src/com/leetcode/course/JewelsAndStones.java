package com.leetcode.course;

import java.util.Arrays;

public class JewelsAndStones {

    public static void main(String[] args) {
        JewelsAndStones obj = new JewelsAndStones();
        System.out.println(obj.numJewelsInStones("a", "abcd"));
    }

    public int numJewelsInStones(String jewels, String stones) {
        char[] jewelsArr = new char[58];
        for (char jewel : jewels.toCharArray()) {
            jewelsArr[jewel-65] = jewel;
        }

        int count = 0;
        for (char stone : stones.toCharArray()) {
            if (stone == jewelsArr[stone - 65]) {
                count++;
            }
        }

        return count;
    }
}

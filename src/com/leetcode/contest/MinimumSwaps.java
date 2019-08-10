package com.leetcode.contest;

public class MinimumSwaps {

    public static void main(String[] args) {
        System.out.println(minSwaps(new int[]{1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1}));
    }

    private static int minSwaps(int[] data) {
        int onesCount = findNumOfOnes(data);
        if (onesCount <= 1) {
            return 0;
        }
        int i = 0, j = 0, zeroCount = 0, minCount = Integer.MAX_VALUE;
        while (j <= onesCount - 1) {
            if (data[j] == 0) {
                zeroCount++;
            }
            j++;
        }
        if (minCount > zeroCount) {
            minCount = zeroCount;
        }
        j--;
        while (j < data.length - 1) {
            int leave = data[i++];
            int add = data[++j];
            if (leave == 0 && add == 1) {
                zeroCount--;
            } else if (leave == 1 && add == 0) {
                zeroCount++;
            }
            if (minCount > zeroCount) {
                minCount = zeroCount;
            }
        }
        return minCount;
    }

    private static int findNumOfOnes(int[] data) {
        int count = 0;
        for (int datum : data) {
            if (datum == 1) {
                count++;
            }
        }
        return count;
    }
}

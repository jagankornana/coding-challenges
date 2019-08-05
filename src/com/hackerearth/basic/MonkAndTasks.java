package com.hackerearth.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MonkAndTasks {

    private static long[] ARRAY;
    private static Map<Long, Integer> MEMORY = new HashMap<>();

    public static Comparator<Long> SetBitComparator = (o1, o2) -> {
        int count1 = MEMORY.get(o1);
        int count2 = MEMORY.get(o2);
        return count1 - count2;
    };

    private static void setBitCount(Long num) {
        Long key = num;
        if (MEMORY.get(num) == null) {
            int count = 0;
            while (num > 0) {
                num = num & (num - 1);
                count++;
            }
            MEMORY.put(key, count);
        }
    }

    private static void mergeSort(int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(p, q);
            mergeSort(q + 1, r);
            merge(p, q, r);
        }
    }

    private static void merge(int p, int q, int r) {
        int leftArrSize = q - p + 1;
        int rightArrSize = r - q;
        long[] leftArray = new long[leftArrSize];
        long[] rightArray = new long[rightArrSize];

        System.arraycopy(ARRAY, p, leftArray, 0, leftArrSize);

        for (int i = 0; i < rightArrSize; i++) {
            rightArray[i] = ARRAY[q + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = p;
        while (i < leftArrSize && j < rightArrSize) {
            if (MEMORY.get(leftArray[i]) <= MEMORY.get(rightArray[j]))
                ARRAY[k++] = leftArray[i++];
            else
                ARRAY[k++] = rightArray[j++];
        }
        while (i < leftArrSize)
            ARRAY[k++] = leftArray[i++];
        while (j < rightArrSize)
            ARRAY[k++] = rightArray[j++];
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] nums = br.readLine().split(" ");
            ARRAY = new long[n];

            for (int j = 0; j < n; j++) {
                ARRAY[j] = Long.parseLong(nums[j]);
                setBitCount(ARRAY[j]);
            }

//			Arrays.sort(tasks, SetBitComparator);
            mergeSort(0, ARRAY.length - 1);

            for (Long task : ARRAY) {
                System.out.print(task + " ");
            }
            System.out.println();
        }
    }

}

package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiscoverTheMonk {

    public static int[] array;

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
        int[] leftArray = new int[leftArrSize];
        int[] rightArray = new int[rightArrSize];

        System.arraycopy(array, p, leftArray, 0, leftArrSize);

        for (int i = 0; i < rightArrSize; i++) {
            rightArray[i] = array[q + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = p;
        while (i < leftArrSize && j < rightArrSize) {
            if (leftArray[i] <= rightArray[j])
                array[k++] = leftArray[i++];
            else
                array[k++] = rightArray[j++];
        }
        while (i < leftArrSize)
            array[k++] = leftArray[i++];
        while (j < rightArrSize)
            array[k++] = rightArray[j++];
    }

    private static void binarySearch(int low, int high, int element) {
        boolean flag = true;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == element) {
                System.out.println("YES");
                flag = false;
                break;
            } else if (element < array[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        if (flag)
            System.out.println("NO");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st=new StringTokenizer(br.readLine(), " ");
        String[] strings = br.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int q = Integer.parseInt(strings[1]);
        strings = br.readLine().split(" ");
        array = new int[n];
        for (int i = 0; i < strings.length; i++) {
            array[i] = Integer.parseInt(strings[i]);
        }
        mergeSort(0, n - 1);

        for (int i = 0; i < q; i++) {
            binarySearch(0, n - 1, Integer.parseInt(br.readLine()));
        }
    }
}

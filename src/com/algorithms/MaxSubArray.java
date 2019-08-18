package com.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxSubArray {

    public static int[] array;

    private static int[] findMaxSubArray(int low, int high) {
        if (low == high) {
            return new int[]{low, high, array[low]};
        } else {
            int[] leftArray;
            int[] rightArray;
            int[] crossArray;
            int mid = (low + high) / 2;
            leftArray = findMaxSubArray(low, mid);
            rightArray = findMaxSubArray(mid + 1, high);
            crossArray = findMaxCrossSubArray(low, mid, high);

            if (leftArray[2] > rightArray[2] && leftArray[2] > crossArray[2])
                return leftArray;
            else if (rightArray[2] > leftArray[2]
                    && rightArray[2] > crossArray[2])
                return rightArray;
            else
                return crossArray;
        }
    }

    private static int[] findMaxCrossSubArray(int low, int mid, int high) {
        int leftSum = array[mid];
        int maxLeft = mid;
        int sum = array[mid];
        for (int i = mid - 1; i >= 0; i--) {
            sum += array[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        int rightSum = array[mid + 1];
        int maxRight = mid + 1;
        sum = array[mid + 1];
        for (int i = mid + 2; i <= high; i++) {
            sum += array[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }
        return new int[]{maxLeft, maxRight, leftSum + rightSum};
    }

    public static void main(String[] args) throws NumberFormatException,
            IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        int[] maxSubArray = findMaxSubArray(0, n - 1);
        System.out.println(maxSubArray[0] + " " + maxSubArray[1] + " "
                + maxSubArray[2]);

        System.out.print("Maximum Sub Array: ");

        for (int i = maxSubArray[0]; i <= maxSubArray[1]; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

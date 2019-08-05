package com.hackerearth.datastructures.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class TheAmazingRace_Stack {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            String[] strings = br.readLine().split(" ");
            int[] vehicleHeights = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                vehicleHeights[i] = Integer.parseInt(strings[i - 1]);

            }

            if (n == 1) {
                System.out.println("1");
                continue;
            }

            Stack<Integer> stack = new Stack<>();
            long[] leftVehicles = new long[n + 1];
            leftVehicles[1] = 0;
            stack.push(1);
            for (int i = 2; i < vehicleHeights.length; i++) {
                if (vehicleHeights[i] <= vehicleHeights[stack.peek()]) {
                    leftVehicles[i] = 1;
                    stack.push(i);
                } else {
                    do {
                        stack.pop();
                        if (stack.isEmpty()) {
                            break;
                        }
                    } while (vehicleHeights[i] > vehicleHeights[stack.peek()]);
                    if (stack.isEmpty()) {
                        leftVehicles[i] = i - 1;
                        stack.push(i);
                    } else {
                        leftVehicles[i] = i - stack.peek();
                        stack.push(i);
                    }
                }
            }

            if (!stack.isEmpty()) {
                stack.clear();
            }

            long[] rightVehicles = new long[n + 1];
            rightVehicles[n] = 0;
            stack.push(n);
            for (int i = n - 1; i > 0; i--) {
                if (vehicleHeights[i] <= vehicleHeights[stack.peek()]) {
                    rightVehicles[i] = 1;
                    stack.push(i);
                } else {
                    do {
                        stack.pop();
                        if (stack.isEmpty()) {
                            break;
                        }
                    } while (vehicleHeights[i] > vehicleHeights[stack.peek()]);
                    if (stack.isEmpty()) {
                        rightVehicles[i] = n - i;
                        stack.push(i);
                    } else {
                        rightVehicles[i] = stack.peek() - i;
                        stack.push(i);
                    }
                }
            }

            long maxSight = -1;
            long maxSightIndex = -1;
            for (long i = 1L; i <= n; i++) {
                long sight = (((leftVehicles[(int) i] + rightVehicles[(int) i]) % 1000000007) * i) % 1000000007;
                if (sight > maxSight) {
                    maxSight = sight;
                    maxSightIndex = i;
                }
            }

            System.out.println(maxSightIndex);
        }
    }
}

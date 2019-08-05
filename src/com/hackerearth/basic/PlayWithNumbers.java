package com.hackerearth.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PlayWithNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int q = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        Map<Integer, Long> sumMap = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(input[i]);
            sumMap.put(i + 1, sum);
        }
        for (int i = 0; i < q; i++) {
            input = br.readLine().split(" ");
            int l = Integer.parseInt(input[0]);
            int r = Integer.parseInt(input[1]);
            long subArrSum;
            if (l == 1) {
                subArrSum = sumMap.get(r);
            } else {
                subArrSum = sumMap.get(r) - sumMap.get(l - 1);
            }
            System.out.println(subArrSum / (r - l + 1));
        }
    }
}

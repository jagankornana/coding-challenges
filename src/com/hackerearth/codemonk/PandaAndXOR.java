package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;

public class PandaAndXOR {

    public static void powerSet(int[] set, int setSize) {
        long powerSetSize = (long) Math.pow(2, setSize);
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        for (long i = 1; i < powerSetSize; i++) {
            boolean flag = true;
            long maxor = 0;
            for (int j = 0; j < setSize; j++) {
                if ((i & (1 << j)) != 0) {
                    if (flag) {
                        maxor = set[(setSize - 1) - j];
                        flag = false;
                    } else
                        maxor ^= set[(setSize - 1) - j];
                }
            }
            if (map.containsKey(maxor))
                map.put(maxor, map.get(maxor) + 1);
            else
                map.put(maxor, 1);
        }
        BigInteger result = BigInteger.ZERO;
        for (int element : map.values()) {
            if (element > 1) {
                long sum = sumofIntegers(element - 1);
                result = result.add(new BigInteger(Long.toString(sum)));
            }
        }

        System.out.println(result.mod(new BigInteger("1000000007")));
    }

    public static long sumofIntegers(long n) {
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] set = new int[n];
        for (int i = 0; i < n; i++)
            set[i] = Integer.parseInt(br.readLine());
        powerSet(set, n);
    }
}

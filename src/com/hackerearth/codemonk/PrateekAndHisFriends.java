package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrateekAndHisFriends {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < testCases; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int numOfFrnds = Integer.parseInt(st.nextToken());
            long amount = Long.parseLong(st.nextToken());
            int[] costArray = new int[numOfFrnds];
            for (int j = 0; j < numOfFrnds; j++) {
                costArray[j] = Integer.parseInt(br.readLine());
            }

            boolean flag = true;
            long sum = costArray[0];
            for (int p = 0, q = 0; p < costArray.length; ) {
                if (sum == amount) {
                    System.out.println("YES");
                    flag = false;
                    break;
                } else if (sum < amount) {
                    q++;
                    if (q < costArray.length)
                        sum += costArray[q];
                    else
                        break;
                } else {
                    sum -= costArray[p];
                    p++;
                }
            }
            if (flag)
                System.out.println("NO");
        }
    }
}

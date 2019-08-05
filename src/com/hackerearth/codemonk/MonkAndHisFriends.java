package com.hackerearth.codemonk;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class MonkAndHisFriends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        int t = sc.nextInt();
        sc.nextLine();
        for (int j = 0; j < t; j++) {
            String[] inputValues = sc.nextLine().split(" ");
            int n = Integer.parseInt(inputValues[0]);
            int m = Integer.parseInt(inputValues[1]);
            // inputValues = sc.nextLine().split(" ");
            st = new StringTokenizer(sc.nextLine(), " ");
            int i = 0;
            Set<Long> set = new HashSet<>();
            for (; i < n; i++) {
                set.add(Long.parseLong(st.nextToken()));
            }
            for (; i < n + m; i++) {
                long value = Long.parseLong(st.nextToken());
                if (set.contains(value)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                    set.add(value);
                }
            }
        }
        sc.close();
    }
}

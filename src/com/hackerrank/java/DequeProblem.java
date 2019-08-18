package com.hackerrank.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;

public class DequeProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        int maxUniqueNums = 0;
        for (int i = 0; i <= n; i++) {
            if (i < m) {
                int input = sc.nextInt();
                deque.add(input);
                set.add(input);
            } else {
                if (set.size() > maxUniqueNums)
                    maxUniqueNums = set.size();
                int removeElement = deque.remove();
                if (i != n) {
                    int input = sc.nextInt();
                    deque.add(input);
                    if (!deque.contains(removeElement))
                        set.remove(removeElement);
                    set.add(input);
                }
            }
        }
        System.out.println(maxUniqueNums);
        sc.close();
    }
}
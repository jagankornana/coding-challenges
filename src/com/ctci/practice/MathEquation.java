package com.ctci.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/*a^3 + b^3 = c^3 + d^3*/

public class MathEquation {
    long endTime = System.currentTimeMillis();

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int count = 1;
        int limit = 10;
        int result;
        HashMap<Integer, List<Pair>> map = new HashMap<>();
        for (int a = 1; a <= limit; a++) {
            for (int b = 1; b <= limit; b++) {
                result = computeEquation(a, b);
                if (map.get(result) == null) {
                    map.put(result, new ArrayList<>());
                    map.get(result).add(new Pair(a, b));
                } else {
                    map.get(result).add(new Pair(a, b));
                }
            }
        }
        Collection<List<Pair>> pairs = map.values();
        for (List<Pair> pairList : pairs) {
            for (Pair firstPair : pairList) {
                for (Pair secondPair : pairList) {
                    System.out.println(count++ + ") a=" + firstPair.getA() + ", b=" + firstPair.getB()
                            + ", c=" + secondPair.getA() + ", d=" + secondPair.getB());
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("\nTotal time in millis: " + (endTime - startTime));
    }


    private static int computeEquation(int a, int b) {
        return (a * a * a) + (b * b * b);
    }

    private static class Pair {
        int a;
        int b;

        private Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        private int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        private int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }
}

package com.leetcode.course;

import java.util.HashMap;
import java.util.HashSet;

public class MinimumConsecutiveCards {

    public static void main(String[] args) {
        MinimumConsecutiveCards obj = new MinimumConsecutiveCards();
        System.out.println(obj.minimumCardPickup(new int[]{3,4,3,2,4,2,2}));
        System.out.println(obj.minimumCardPickupUsingSlidingWindow(new int[]{1,2,3,1}));
    }

    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int minLength = 999999;
        for (int i = 0; i < cards.length; i++) {
            if (hashMap.containsKey(cards[i])) {
                minLength = Math.min(minLength, i - hashMap.get(cards[i]) + 1);
            }
            hashMap.put(cards[i], i);
        }

        return minLength == 999999 ? -1 : minLength;
    }

    public int minimumCardPickupUsingSlidingWindow(int[] cards) {
        HashSet<Integer> hashSet = new HashSet<>();
        int i = 0, minLength = 999999;
        hashSet.add(cards[i]);
        for (int j = 1; j < cards.length; j++) {
            while (hashSet.contains(cards[j])) {
                minLength = Math.min(minLength, j - i + 1);
                hashSet.remove(cards[i++]);
            }
            hashSet.add(cards[j]);
        }

        return minLength == 999999 ? -1 : minLength;
    }
}

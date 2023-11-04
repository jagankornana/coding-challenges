package com.poc.practice;

import java.util.ArrayList;
import java.util.List;

public class PlayersWithZeroOrOneLosses {

    public static void main(String[] args) {
        PlayersWithZeroOrOneLosses obj = new PlayersWithZeroOrOneLosses();
        int[][] input = {{1, 3}, {2, 1}, {3, 2}};
        List<List<Integer>> winners = obj.findWinners(input);
        System.out.println(winners);
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        int[] winnersFreq = new int[100001];
        int[] losersFreq = new int[100001];
        for (int[] match : matches) {
            winnersFreq[match[0]]++;
            losersFreq[match[1]]++;
        }

        ArrayList<Integer> winners = new ArrayList<>();
        ArrayList<Integer> losers = new ArrayList<>();
        for (int i = 1; i < 100001; i++) {
            if (winnersFreq[i] > 0 && losersFreq[i] == 0) {
                winners.add(i);
            } else if (losersFreq[i] == 1) {
                losers.add(i);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(winners);
        result.add(losers);
        return result;
    }
}

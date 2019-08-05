package com.hackerearth.datastructures.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MarkTheAnswer {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int numOfQ = Integer.parseInt(strings[0]);
        int maxDifficulty = Integer.parseInt(strings[1]);
        int[] array = new int[numOfQ];
        strings = br.readLine().split(" ");
        for (int i = 0; i < numOfQ; i++) {
            array[i] = Integer.parseInt(strings[i]);
        }

        int score = 0;
        int skip = 0;
        for (int anArray : array) {
            if (anArray <= maxDifficulty) {
                score++;
            } else if (skip < 1) {
                skip++;
            } else {
                break;
            }
        }

        System.out.println(score);
    }
}

package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MonkandPowerofTime {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputValues = br.readLine().split(" ");
        ArrayList<Integer> callingOrder = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            callingOrder.add(Integer.parseInt(inputValues[i]));
        }
        inputValues = br.readLine().split(" ");
        ArrayList<Integer> idealOrder = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            idealOrder.add(Integer.parseInt(inputValues[i]));
        }
        int totalTimeTaken = 0;
        while (!idealOrder.isEmpty()) {
            if (idealOrder.get(0).equals(callingOrder.get(0))) {
                idealOrder.remove(0);
                callingOrder.remove(0);
                totalTimeTaken++;
            } else {
                int value = callingOrder.remove(0);
                callingOrder.add(value);
                totalTimeTaken++;
            }
        }
        System.out.println(totalTimeTaken);
    }
}

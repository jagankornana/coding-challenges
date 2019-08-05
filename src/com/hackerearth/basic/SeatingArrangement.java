package com.hackerearth.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SeatingArrangement {

    private static Map<Integer, Integer> oppositeSeatMap = initMap();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int seatNum = Integer.parseInt(br.readLine());
            findOppSeat(seatNum);
            findSeatType(seatNum);
            System.out.println();
        }
    }

    private static void findSeatType(int seatNum) {
        if (seatNum % 6 == 0 || seatNum % 6 == 1) {
            System.out.print(" WS");
        } else if (seatNum % 6 == 2 || seatNum % 6 == 5) {
            System.out.print(" MS");
        } else {
            System.out.print(" AS");
        }
    }

    private static void findOppSeat(int seatNum) {
        System.out.print(seatNum + oppositeSeatMap.get(seatNum % 12));
    }

    private static Map<Integer, Integer> initMap() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 11);
        map.put(2, 9);
        map.put(3, 7);
        map.put(4, 5);
        map.put(5, 3);
        map.put(6, 1);
        map.put(7, -1);
        map.put(8, -3);
        map.put(9, -5);
        map.put(10, -7);
        map.put(11, -9);
        map.put(0, -11);

        return map;
    }
}

package com.hackerrank.problems;

import java.util.Scanner;

public class TimeConversion {
    public static void main(String[] args) {
        String time;
        Scanner sc = new Scanner(System.in);
        time = sc.nextLine();
        if (time.endsWith("AM")) {
            if (Integer.parseInt(time.substring(0, time.indexOf(':'))) == 12) {
                System.out.println("00"
                        + time.substring(time.indexOf(':'), time.indexOf('A')));
            } else
                System.out.println(time.substring(0, time.indexOf('A')));
        } else {
            if (Integer.parseInt(time.substring(0, time.indexOf(':'))) == 12) {
                System.out.println("12"
                        + time.substring(time.indexOf(':'), time.indexOf('P')));
            } else {
                int hours = Integer.parseInt(time.substring(0,
                        time.indexOf(':')));
                hours += 12;
                System.out.println(hours
                        + time.substring(time.indexOf(':'), time.indexOf('P')));
            }
        }
        sc.close();
    }
}

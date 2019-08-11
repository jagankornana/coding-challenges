package com.leetcode.contest;

public class DayOfTheYear {

    public static void main(String[] args) {
        System.out.println(dayOfYear("2019-01-09"));
        System.out.println(dayOfYear("2019-02-10"));
        System.out.println(dayOfYear("2003-03-01"));
        System.out.println(dayOfYear("2004-03-01"));
        System.out.println(dayOfYear("2016-02-29"));
        System.out.println(dayOfYear("1976-01-24"));
    }

    private static int dayOfYear(String date) {
        String[] strs = date.split("-");
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = Integer.valueOf(strs[0]);
        int month = Integer.valueOf(strs[1]);
        int day = Integer.valueOf(strs[2]);
        int dayCount = 0;
        for (int i = 0; i < month - 1; i++) {
            dayCount += monthDays[i];
            if (i == 1 && isLeafYear(year)) {
                dayCount += 1;
            }
        }
        dayCount += day;

        return dayCount;
    }

    private static boolean isLeafYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }
}

package com.leetcode.course;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures obj = new DailyTemperatures();
        int[] input = {40,30,20,90};
        System.out.println(Arrays.toString(obj.dailyTemperatures(input)));
        System.out.println(Arrays.toString(obj.dailyTemperatures_Efficient(input)));
    }

    public int[] dailyTemperatures_Efficient(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int currDay = 0; currDay < temperatures.length; currDay++) {
            int currTemp = temperatures[currDay];
            while (!stack.isEmpty() && temperatures[stack.peek()] < currTemp) {
                int prevDay = stack.pop();
                result[prevDay] = currDay - prevDay;
            }
            stack.push(currDay);
        }
        return result;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Temperature> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        stack.push(new Temperature(temperatures[n - 1], 0));
        result[n - 1] = 0;
        for (int i = temperatures.length - 1; i >= 0; i--) {
            if (temperatures[i] < stack.peek().temp) {
                stack.push(new Temperature(temperatures[i], 1));
                result[i] = 1;
            } else {
                int days = 0;
                while (!stack.isEmpty() && temperatures[i] >= stack.peek().temp) {
                    Temperature temp = stack.pop();
                    days += temp.days;
                }
                days = stack.isEmpty() ? 0 : days + 1;
                stack.push(new Temperature(temperatures[i], days));
                result[i] = days;
            }
        }

        return result;
    }
}

class Temperature {
    int temp;
    int days;

    Temperature(int temp, int days) {
        this.temp = temp;
        this.days = days;
    }
}

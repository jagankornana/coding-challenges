package com.leetcode.contests;

public class MaxNumOfBalloons {

    public static void main(String[] args) {
        MaxNumOfBalloons balloons = new MaxNumOfBalloons();
        System.out.println(balloons.maxNumberOfBalloons("nlaebolko"));
        System.out.println(balloons.maxNumberOfBalloons("nl"));
        System.out.println(balloons.maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(balloons.maxNumberOfBalloons("leetcode"));
    }

    private int maxNumberOfBalloons(String text) {
        int[] arr = new int[5];
        for (char ch : text.toCharArray()) {
            switch (ch) {
                case 'b':
                    arr[0] += 1;
                    break;
                case 'a':
                    arr[1] += 1;
                    break;
                case 'l':
                    arr[2] += 1;
                    break;
                case 'o':
                    arr[3] += 1;
                    break;
                case 'n':
                    arr[4] += 1;
                    break;
            }
        }

        int balCount = 0;
        while (true) {
            if (arr[0] > 0 && arr[1] > 0 && arr[2] > 1 && arr[3] > 1 && arr[4] > 0) {
                arr[0] -= 1;
                arr[1] -= 1;
                arr[2] -= 2;
                arr[3] -= 2;
                arr[4] -= 1;
                balCount++;
            } else {
                break;
            }
        }

        return balCount;
    }
}

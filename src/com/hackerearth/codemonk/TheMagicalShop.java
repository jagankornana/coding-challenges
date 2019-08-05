package com.hackerearth.codemonk;

import java.util.Scanner;

public class TheMagicalShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputValues = sc.nextLine().split(" ");
        long a = Integer.parseInt(inputValues[0]);
        long b = Integer.parseInt(inputValues[1]);
        String binaryStr = sc.nextLine();
        long portionsBought = 0;
        if (binaryStr.charAt(0) == '1')
            portionsBought = ((portionsBought % b) + (a % b)) % b;
        for (int i = 1; i < binaryStr.length(); i++) {
            a = ((a % b) * (a % b)) % b;
            if (binaryStr.charAt(i) == '1') {
                portionsBought = (portionsBought + a) % b;
            }
        }
        System.out.println(portionsBought);
        sc.close();
    }
}

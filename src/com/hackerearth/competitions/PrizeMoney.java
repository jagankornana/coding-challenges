package com.hackerearth.competitions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class PrizeMoney {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> strings = Arrays.asList(br.readLine().split(" "));
        CopyOnWriteArrayList<Integer> input = strings.stream().sorted()
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(CopyOnWriteArrayList::new));
        for (int i = 0; i < input.size(); i++) {
            int num = input.get(i);
            for (int j = i + 1; j < input.size(); j++) {
                if (input.get(j) % num == 0) {
                    input.remove(j);
                }
            }
        }

        int maxCurDeno = input.get(input.size() - 1);
        HashSet<Integer> hashSet = new HashSet<>(input);
        boolean flag = false;
        for (int i = maxCurDeno + 1; i <= maxCurDeno * 2; i++) {
            flag = true;
            for (Integer num : input) {
                int rem = i % num;
                if (rem == 0) {
                    flag = false;
                    break;
                } else if (hashSet.contains(rem)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(i);
                break;
            }
        }
        if (!flag) {
            System.out.println("Fake Offer!");
        }
    }
}

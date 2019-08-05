package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class KingdomOfMonkeys {

    private static ArrayList<ArrayList<Integer>> adjList;
    private static ArrayList<Integer> component = new ArrayList<>();
    private static boolean[] visited;

    private static void depthFirstSearchIterative(int firstMonkey) {
        Stack<Integer> stack = new Stack<>();
        stack.push(firstMonkey);
        visited[firstMonkey] = true;
        while (!stack.isEmpty()) {
            int currentMonkey = stack.pop();
            component.add(currentMonkey);
            for (int adjMonkey = 0; adjMonkey < adjList.get(currentMonkey).size(); adjMonkey++) {
                if (!visited[adjList.get(currentMonkey).get(adjMonkey)]) {
                    stack.push(adjList.get(currentMonkey).get(adjMonkey));
                    visited[adjList.get(currentMonkey).get(adjMonkey)] = true;
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int p = 0; p < t; p++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            adjList = new ArrayList<>(n + 1);
            for (int i = 0; i <= n; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int ritual = 0; ritual < m; ritual++) {
                st = new StringTokenizer(br.readLine(), " ");
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                adjList.get(i).add(j);
                adjList.get(j).add(i);
            }

            st = new StringTokenizer(br.readLine(), " ");
            long[] bananaArray = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                bananaArray[i] = Long.parseLong(st.nextToken());
            }

            visited = new boolean[n + 1];
            Arrays.fill(visited, false);
            long numOfGoldCoins = 0;
            for (int monkey = 1; monkey <= n; monkey++) {
                if (!visited[monkey]) {
                    depthFirstSearchIterative(monkey);
                    long sum = 0;
                    for (Integer aComponent : component) {
                        sum += bananaArray[aComponent];
                    }
                    if (sum > numOfGoldCoins)
                        numOfGoldCoins = sum;
                    component.clear();
                }
            }
            System.out.println(numOfGoldCoins);
        }
    }
}

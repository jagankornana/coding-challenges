package com.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pair implements Comparable<Pair> {
    private int vertix;
    private int weight;

    Pair(int vertix, int weight) {
        this.vertix = vertix;
        this.weight = weight;
    }

    int getVertix() {
        return vertix;
    }

    public void setVertix(int vertix) {
        this.vertix = vertix;
    }

    int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Pair o) {
        return Integer.compare(this.getWeight(), o.getWeight());
    }

}

public class PrimsAlgorithm {

    private static int primsAlgorithm(int startingVertix, ArrayList<ArrayList<Pair>> adjList, int vertices) {
        int minimumCost = 0;
        boolean[] marked = new boolean[vertices + 1];
        Arrays.fill(marked, false);
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(startingVertix, 0));
        while (!queue.isEmpty()) {
            Pair p = queue.remove();
            int currentVertix = p.getVertix();
            if (marked[currentVertix]) {
                continue;
            }
            minimumCost += p.getWeight();
            marked[currentVertix] = true;
            for (int i = 0; i < adjList.get(currentVertix).size(); i++) {
                Pair pair = adjList.get(currentVertix).get(i);
                if (!marked[pair.getVertix()]) {
                    queue.add(pair);
                }
            }
        }
        return minimumCost;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int vertices = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>(vertices + 1);
        for (int i = 0; i <= vertices; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int edge = 0; edge < edges; edge++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            Pair pair = new Pair(j, w);
            adjList.get(i).add(pair);
            pair = new Pair(i, w);
            adjList.get(j).add(pair);
        }

        int minimumCost = primsAlgorithm(0, adjList, vertices);
        System.out.println("Minimum cost: " + minimumCost);
    }
}

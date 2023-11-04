package com.poc.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ReorderRoutesToCityZero {

    HashMap<Integer, HashSet<Integer>> adjMatrix;
    HashMap<Integer, List<Integer>> undirectedGraph;
    boolean[] seen;
    int ans;

    public static void main(String[] args) {
        int[][] input = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        ReorderRoutesToCityZero obj = new ReorderRoutesToCityZero();
        System.out.println(obj.minReorder(6, input));
    }

    public int minReorder(int n, int[][] connections) {
        seen = new boolean[n];
        ans = 0;
        initGraphs(connections);
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                dfs(i);
            }
        }
        return ans;
    }

    private void dfs(int vertex) {
        seen[vertex] = true;
        for (Integer neighbour : undirectedGraph.get(vertex)) {
            if (!seen[neighbour]) {
                if (adjMatrix.getOrDefault(vertex, new HashSet<>()).contains(neighbour)) {
                    ans++;
                }
                dfs(neighbour);
            }
        }
    }

    private void initGraphs(int[][] connections) {
        adjMatrix = new HashMap<>();
        undirectedGraph = new HashMap<>();
        for (int[] connection : connections) {
            int x = connection[0], y = connection[1];
            if (!adjMatrix.containsKey(x)) {
                adjMatrix.put(x, new HashSet<>());
            }
            adjMatrix.get(x).add(y);

            if (!undirectedGraph.containsKey(x)) {
                undirectedGraph.put(x, new ArrayList<>());
            }
            undirectedGraph.get(x).add(y);

            if (!undirectedGraph.containsKey(y)) {
                undirectedGraph.put(y, new ArrayList<>());
            }
            undirectedGraph.get(y).add(x);
        }
    }
}

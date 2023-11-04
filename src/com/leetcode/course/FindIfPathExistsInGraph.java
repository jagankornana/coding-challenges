package com.poc.practice;

import java.util.HashMap;
import java.util.HashSet;

public class FindIfPathExistsInGraph {

    HashMap<Integer, HashSet<Integer>> graph;
    boolean[] seen;
    boolean pathExist;

    public static void main(String[] args) {
        int[][] edges = {};
        FindIfPathExistsInGraph obj = new FindIfPathExistsInGraph();
        System.out.println(obj.validPath(1, edges, 0, 0));
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        graph = new HashMap<>();
        seen = new boolean[n];
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            if (!graph.containsKey(x)) {
                graph.put(x, new HashSet<>());
            }
            graph.get(x).add(y);
            if (!graph.containsKey(y)) {
                graph.put(y, new HashSet<>());
            }
            graph.get(y).add(x);
        }
        dfs(source, destination);
        return pathExist;
    }

    private void dfs(int source, int destination) {
        seen[source] = true;
        HashSet<Integer> neighbours = graph.get(source);
        if (neighbours != null) {
            if (neighbours.contains(destination)) {
                pathExist = true;
                return;
            }
            for (Integer neighbour : neighbours) {
                if (!seen[neighbour]) {
                    dfs(neighbour, destination);
                }
            }
        }
    }
}

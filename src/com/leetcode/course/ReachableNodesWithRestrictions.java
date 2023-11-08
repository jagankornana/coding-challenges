package com.leetcode.course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ReachableNodesWithRestrictions {
    HashMap<Integer, List<Integer>> graph;
    HashSet<Integer> restrictedNodes;
    boolean[] seen;
    private int reachableNodes;

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {0, 5}, {0, 4}, {3, 2}, {6, 5}};
        int[] restricted = {4,2,1};
        ReachableNodesWithRestrictions obj = new ReachableNodesWithRestrictions();
        System.out.println(obj.reachableNodes(7, edges, restricted));
    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        graph = new HashMap<>();
        restrictedNodes = new HashSet<>();
        seen = new boolean[n];
        reachableNodes = 0;
        for (int node : restricted) {
            restrictedNodes.add(node);
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            if (!(restrictedNodes.contains(x) || restrictedNodes.contains(y))) {
                if (!graph.containsKey(x)) {
                    graph.put(x, new ArrayList<>());
                }
                graph.get(x).add(y);
                if (!graph.containsKey(y)) {
                    graph.put(y, new ArrayList<>());
                }
                graph.get(y).add(x);
            }
        }
        dfs(0);
        return reachableNodes;
    }

    private void dfs(int node) {
        seen[node] = true;
        reachableNodes++;
        for (Integer neighbour : graph.getOrDefault(node, new ArrayList<>())) {
            if (!seen[neighbour]) {
                dfs(neighbour);
            }
        }
    }
}

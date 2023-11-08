package com.leetcode.course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumberOfProvinces {

    public static void main(String[] args) {
        int[][] adjMatrix = {
                {0, 1, 1, 0, 0},
                {1, 0, 1, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        NumberOfProvinces obj = new NumberOfProvinces();
        System.out.println(obj.findCircleNum(adjMatrix));
    }

    public int findCircleNum(int[][] adjMatrix) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] seen = new boolean[adjMatrix.length];
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = i + 1; j < adjMatrix[i].length; j++) {
                if (adjMatrix[i][j] == 1) {
                    if (!graph.containsKey(i)) {
                        graph.put(i, new ArrayList<>());
                    }
                    graph.get(i).add(j);
                    if (!graph.containsKey(j)) {
                        graph.put(j, new ArrayList<>());
                    }
                    graph.get(j).add(i);
                }
            }
        }
        int provinces = 0;
        for (int i = 0; i < adjMatrix.length; i++) {
            if (!seen[i]) {
                provinces++;
                dfs(graph, seen, i);
            }
        }
        return provinces;
    }

    private void dfs(HashMap<Integer, List<Integer>> graph, boolean[] seen, int vertex) {
        seen[vertex] = true;
        List<Integer> neighbours = graph.getOrDefault(vertex, new ArrayList<>());
        for (Integer neighbour : neighbours) {
            if (!seen[neighbour]) {
                dfs(graph, seen, neighbour);
            }
        }
    }
}

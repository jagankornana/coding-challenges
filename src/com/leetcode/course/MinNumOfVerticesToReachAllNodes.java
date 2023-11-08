package com.leetcode.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinNumOfVerticesToReachAllNodes {

    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(2, 1));
        edges.add(Arrays.asList(3, 1));
        edges.add(Arrays.asList(1, 4));
        edges.add(Arrays.asList(2, 4));

        MinNumOfVerticesToReachAllNodes obj = new MinNumOfVerticesToReachAllNodes();
        System.out.println(obj.findSmallestSetOfVertices(5, edges));
    }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inDegree = new int[n];
        for (List<Integer> edge : edges) {
            inDegree[edge.get(1)]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }
}

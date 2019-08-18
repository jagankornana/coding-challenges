package com.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Edge {
    private int x;
    private int y;

    Edge(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    String getEdge() {
        return "(" + x + "," + y + ")";
    }
}

public class KruskalsAlgorithm {

    public static int[] array;

    private static void disjointSetUnion(int vertices) {
        array = new int[vertices + 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    private static int root(int index) {
        while (array[index] != index) {
            index = array[array[index]];
        }
        return index;
    }

    private static void union(int x, int y) {
        int rootX = root(x);
        int rootY = root(y);
        array[rootX] = rootY;
    }

    private static int kruskalAlgorithm(TreeMap<Integer, ArrayList<Edge>> weightedGraph) {
        int minimumCost = 0;

        Set<Integer> weights = weightedGraph.keySet();
        for (Integer w : weights) {
            for (int i = 0; i < weightedGraph.get(w).size(); i++) {
                Edge edge = weightedGraph.get(w).get(i);
                int x = edge.getX();
                int y = edge.getY();
                if (root(x) != root(y)) {
                    System.out.println(edge.getEdge());
                    minimumCost += w;
                    union(x, y);
                }
            }
        }

        return minimumCost;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TreeMap<Integer, ArrayList<Edge>> weightedGraph = new TreeMap<>(); // Graph
        int vertices = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());
        disjointSetUnion(vertices);
        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ArrayList<Edge> arrayList;
            if (weightedGraph.containsKey(w)) {
                arrayList = weightedGraph.get(w);
                Edge edge = new Edge(x, y);
                arrayList.add(edge);
            } else {
                arrayList = new ArrayList<>();
                Edge edge = new Edge(x, y);
                arrayList.add(edge);
            }
            weightedGraph.put(w, arrayList);
        }
        int minimumCost = kruskalAlgorithm(weightedGraph);
        System.out.println("Minimum cost: " + minimumCost);
    }
}

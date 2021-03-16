package com.ctci.trees_graphs;

import java.util.LinkedList;

public class RouteBetweenNodes {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);
        graph.printAdjList();
        if (isPathExist(graph, 0, 4)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean isPathExist(Graph graph, int src, int dest) {
        LinkedList<Integer>[] adjList = graph.getAdjList();
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] nodeVisit = new boolean[graph.numOfVertices];
        queue.add(src);
        nodeVisit[src] = true;
        while (!queue.isEmpty()) {
            int node = queue.removeFirst();
            if (node == dest) {
                return true;
            }
            for (Integer adjNode : adjList[node]) {
                if (!nodeVisit[adjNode]) {
                    queue.add(adjNode);
                    nodeVisit[adjNode] = true;
                }
            }
        }

        return false;
    }

    private static class Graph {
        private int numOfVertices;
        private LinkedList<Integer>[] adjList;

        private Graph(int numOfVertices) {
            this.numOfVertices = numOfVertices;
            adjList = new LinkedList[numOfVertices];
            for (int i = 0; i < numOfVertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        private void addEdge(int src, int dest) {
            adjList[src].addFirst(dest);
        }

        private void printAdjList() {
            System.out.println("Adjacency List:");
            for (int i = 0; i < numOfVertices; i++) {
                System.out.print(i);
                for (Integer node : adjList[i]) {
                    System.out.print(" -> " + node);
                }
                System.out.println();
            }
        }

        private LinkedList<Integer>[] getAdjList() {
            return adjList;
        }

        private int getNumOfVertices() {
            return numOfVertices;
        }
    }
}

package com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BFS {

    private static ArrayList<ArrayList<Integer>> adjList;
    private static boolean[] visited;
    private static int[] level;

    private static void breadthFirstSearch(int vertices, int source) {
        Queue queue = new Queue(vertices);
        level = new int[vertices];
        queue.enqueue(source);
        level[source] = 0;
        visited[source] = true;
        while (!queue.isQueueEmpty()) {
            int currentVertix = queue.dequeue();
            System.out.print(currentVertix + " ");
            for (int adjVertix = 0; adjVertix < adjList.get(currentVertix).size(); adjVertix++) {
                if (!visited[adjList.get(currentVertix).get(adjVertix)]) {
                    queue.enqueue(adjList.get(currentVertix).get(adjVertix));
                    visited[adjList.get(currentVertix).get(adjVertix)] = true;
                    level[adjList.get(currentVertix).get(adjVertix)] = level[currentVertix] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        sc.nextLine();
        int edges = sc.nextInt();
        sc.nextLine();
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int edge = 0; edge < edges; edge++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            sc.nextLine();
            adjList.get(i).add(j);
            adjList.get(j).add(i);
        }

        visited = new boolean[vertices];
        Arrays.fill(visited, false);
        System.out.print("BFS	: ");
        breadthFirstSearch(vertices, 0);
        System.out.println();
        System.out.print("Level	: ");
        for (int vertix = 0; vertix < vertices; vertix++) {
            System.out.print(level[vertix] + " ");
        }
        sc.close();
    }
}

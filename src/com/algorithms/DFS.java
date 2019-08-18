package com.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class DFS {

    private static boolean[] visited;

    private static void depthFirstSearchIterate(int[][] adjMatrix, int vertices, int startingVertix) {
        visited = new boolean[vertices + 1];
        Arrays.fill(visited, false);
        Stack stack = new Stack(vertices);
        stack.push(startingVertix);
        visited[startingVertix] = true;
        while (!stack.isEmpty()) {
            int currentVertix = stack.top();
            System.out.print(currentVertix + " ");
            stack.pop();
            for (int adjVertix = 1; adjVertix <= vertices; adjVertix++) {
                if (adjMatrix[currentVertix][adjVertix] == 1 && !visited[adjVertix]) {
                    stack.push(adjVertix);
                    visited[adjVertix] = true;
                }
            }
        }
    }

    private static void depthFirstSearchRecursive(int[][] adjMatrix, int vertices, int currentVertix) {
        visited[currentVertix] = true;
        System.out.print(currentVertix + " ");
        for (int adjVertix = 1; adjVertix <= vertices; adjVertix++) {
            if (adjMatrix[currentVertix][adjVertix] == 1 && !visited[adjVertix]) {
                depthFirstSearchRecursive(adjMatrix, vertices, adjVertix);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        sc.nextLine();
        int edges = sc.nextInt();
        sc.nextLine();
        int[][] adjMatrix = new int[vertices + 1][vertices + 1];
        for (int edge = 0; edge < edges; edge++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            sc.nextLine();
            adjMatrix[i][j] = 1;
            adjMatrix[j][i] = 1;
        }
        System.out.print("DFS Iterative: ");
        depthFirstSearchIterate(adjMatrix, vertices, 1);
        System.out.println();
        System.out.println("DFS Recursive: Connected Components: ");
        visited = new boolean[vertices + 1];
        Arrays.fill(visited, false);
        for (int vertix = 1; vertix <= vertices; vertix++) {
            if (!visited[vertix]) {
                depthFirstSearchRecursive(adjMatrix, vertices, vertix);
                System.out.println();
            }
        }
        sc.close();
    }
}

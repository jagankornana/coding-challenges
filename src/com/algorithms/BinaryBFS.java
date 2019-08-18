package com.algorithms;

import java.util.*;

public class BinaryBFS {

    private static ArrayList<LinkedHashMap<Integer, Integer>> adjList;
    private static int[] distance;

    private static void binaryBFS(int vertices, int source) {

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        distance = new int[vertices];
        Arrays.fill(distance, 100000);
        deque.add(source);
        distance[source] = 0;

        while (!deque.isEmpty()) {
            int currentVertix = deque.removeFirst();
            Object[] adjVertices = adjList.get(currentVertix).keySet().toArray();
            Object[] adjVertixWeights = adjList.get(currentVertix).values().toArray();
            for (int i = 0; i < adjVertices.length; i++) {
                if ((distance[(int) adjVertices[i]]) > (distance[currentVertix] + (int) adjVertixWeights[i])) {

                    distance[(int) adjVertices[i]] = distance[currentVertix] + (int) adjVertixWeights[i];

                    if ((int) adjVertixWeights[i] == 0) {
                        deque.addFirst((int) adjVertices[i]);
                    } else {
                        deque.addLast((int) adjVertices[i]);
                    }
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
            adjList.add(new LinkedHashMap<>());
        }
        for (int edge = 0; edge < edges; edge++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int w = sc.nextInt();
            sc.nextLine();
            adjList.get(i).put(j, w);
            adjList.get(j).put(i, w);
        }

        binaryBFS(vertices, 0);
        System.out.println("Distance from source: ");
        for (int dist : distance) {
            System.out.print(dist + " ");
        }

        sc.close();
    }
}

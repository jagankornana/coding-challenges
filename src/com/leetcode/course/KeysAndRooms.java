package com.poc.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class KeysAndRooms {
    private HashSet<Integer> seen;

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1, 3));
        rooms.add(Arrays.asList(3, 0, 1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));
        KeysAndRooms obj = new KeysAndRooms();
        System.out.println(obj.canVisitAllRooms_Iterative(rooms));
        System.out.println(obj.canVisitAllRooms(rooms));
    }

    private boolean canVisitAllRooms(List<List<Integer>> rooms) {
        seen = new HashSet<>();
        dfs(rooms,0);
        return seen.size() == rooms.size();
    }

    private void dfs(List<List<Integer>> rooms, int vertex) {
        seen.add(vertex);
        for (Integer neighbour : rooms.get(vertex)) {
            if (!seen.contains(neighbour)) {
                dfs(rooms, neighbour);
            }
        }
    }

    public boolean canVisitAllRooms_Iterative(List<List<Integer>> rooms) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[rooms.size()];
        queue.add(0);
        while (!queue.isEmpty()) {
            Integer visitRoom = queue.remove();
            if (!visited[visitRoom]) {
                visited[visitRoom] = true;
                queue.addAll(rooms.get(visitRoom));
            }
        }
        for (boolean roomOpened : visited) {
            if (!roomOpened) {
                return false;
            }
        }
        return true;
    }
}

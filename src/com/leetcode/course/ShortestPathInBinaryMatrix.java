package com.poc.practice;

import java.util.LinkedList;

public class ShortestPathInBinaryMatrix {

    int n;
    int[][] neighbours = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 0, 0, 0},
                {0, 1, 0, 1, 1, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 0}
        };
        ShortestPathInBinaryMatrix obj = new ShortestPathInBinaryMatrix();
        System.out.println(obj.shortestPathBinaryMatrix(grid));
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) {
            return -1;
        }
        n = grid.length;
        LinkedList<State> queue = new LinkedList<>();
        boolean[][] seen = new boolean[n][n];
        queue.add(new State(0, 0, 1));
        seen[0][0] = true;
        while (!queue.isEmpty()) {
            State state = queue.remove();
            if (state.row == n-1 && state.col == n-1)
            for (int[] neighbour : neighbours) {
                int x = state.row + neighbour[0], y = state.col + neighbour[1];
                if (isValid(x, y, grid) && !seen[x][y]) {
                    queue.add(new State(x, y, state.steps + 1));
                }
            }
        }

        return -1;
    }

    private boolean isValid(int i, int j, int[][] grid) {
        return i >= 0 && j >= 0 && i < n && j < n && grid[i][j] == 0;
    }
}

class State {
    int row;
    int col;
    int steps;

    State(int row, int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}

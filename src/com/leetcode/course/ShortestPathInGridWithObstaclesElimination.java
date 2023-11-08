package com.leetcode.course;

import java.util.LinkedList;

public class ShortestPathInGridWithObstaclesElimination {

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;

    public static void main(String[] args) {
        int[][] input = {
                {0, 0, 0},
                {1, 1, 0},
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 0}
        };
        ShortestPathInGridWithObstaclesElimination obj = new ShortestPathInGridWithObstaclesElimination();
        System.out.println(obj.shortestPath(input, 1));
    }

    public int shortestPath(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        LinkedList<MatState> queue = new LinkedList<>();
        boolean[][][] seen = new boolean[m][n][k+1];
        queue.add(new MatState(0, 0, k, 0));
        seen[0][0][k] = true;

        while (!queue.isEmpty()) {
            MatState state = queue.remove();
            int row = state.row, col = state.col, remain = state.remain, steps = state.steps;
            if (row == m - 1 && col == n - 1) {
                return steps;
            }
            for (int[] direction : directions) {
                int nextRow = row + direction[0], nextCol = col + direction[1];
                if (isValidRange(nextRow, nextCol)) {
                    if (grid[nextRow][nextCol] == 0) {
                        if (!seen[nextRow][nextCol][remain]) {
                            seen[nextRow][nextCol][remain] = true;
                            queue.add(new MatState(nextRow, nextCol, remain, steps + 1));
                        }
                    } else if (remain > 0 && !seen[nextRow][nextCol][remain - 1]) {
                        seen[nextRow][nextCol][remain - 1] = true;
                        queue.add(new MatState(nextRow, nextCol, remain - 1, steps + 1));
                    }
                }
            }
        }

        return -1;
    }

    private boolean isValidRange(int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }
}

class MatState {
    int row;
    int col;
    int remain;
    int steps;

    public MatState(int row, int col, int remain, int steps) {
        this.row = row;
        this.col = col;
        this.remain = remain;
        this.steps = steps;
    }
}

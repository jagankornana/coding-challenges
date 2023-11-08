package com.leetcode.course;

import java.util.Arrays;
import java.util.LinkedList;

public class Matrix01 {
    int[][] neighbours = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;

    public static void main(String[] args) {
        int[][] input = {{0, 1, 1, 1, 1, 1, 0, 1}};
        Matrix01 obj = new Matrix01();
        int[][] result = obj.updateMatrix(input);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        LinkedList<CurrState> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new CurrState(i, j, 1));
                }
            }
        }

        int[][] result = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        while (!queue.isEmpty()) {
            CurrState currState = queue.remove();
            int i = currState.row, j = currState.col, steps = currState.steps;
            for (int[] neighbour : neighbours) {
                int x = i + neighbour[0], y = j + neighbour[1];
                if (isValid(x, y, mat) && !seen[x][y]) {
                    seen[x][y] = true;
                    queue.add(new CurrState(x, y, steps + 1));
                    result[x][y] = steps;
                }
            }
        }

        return result;
    }

    private boolean isValid(int i, int j, int[][] mat) {
        return i >= 0 && j >= 0 && i < m && j < n && mat[i][j] == 1;
    }
}

class CurrState {
    int row;
    int col;
    int steps;

    CurrState(int row, int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}

package com.poc.practice;

public class NumberOfIslands {
    char[][] matrix;
    boolean[][] seen;

    public static void main(String[] args) {
        char[][] input = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        NumberOfIslands obj = new NumberOfIslands();
        System.out.println(obj.numIslands(input));
    }

    public int numIslands(char[][] grid) {
        matrix = grid;
        seen = new boolean[matrix.length][matrix[0].length];
        int islands = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (isValid(i, j) && !seen[i][j]) {
                    islands++;
                    dfs(i, j);
                }
            }
        }
        return islands;
    }

    private void dfs(int i, int j) {
        seen[i][j] = true;
        if (isValid(i - 1, j) && !seen[i - 1][j]) {
            dfs(i - 1, j);
        }
        if (isValid(i + 1, j) && !seen[i + 1][j]) {
            dfs(i + 1, j);
        }
        if (isValid(i, j - 1) && !seen[i][j - 1]) {
            dfs(i, j - 1);
        }
        if (isValid(i, j + 1) && !seen[i][j + 1]) {
            dfs(i, j + 1);
        }
    }

    private boolean isValid(int i, int j) {
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[i].length && matrix[i][j] == '1';
    }
}

package com.poc.practice;

public class MaxAreaOfIsland {
    boolean[][] seen;
    int maxArea;

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0, 1}, {1, 0, 1, 0}, {0, 1, 1, 0}};
        MaxAreaOfIsland obj = new MaxAreaOfIsland();
        System.out.println(obj.maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        seen = new boolean[grid.length][grid[0].length];
        maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !seen[i][j]) {
                    maxArea = Math.max(maxArea, dfs(i, j, grid));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || seen[i][j]) {
            return 0;
        }
        seen[i][j] = true;
        return 1 + dfs(i - 1, j, grid) + dfs(i + 1, j, grid) + dfs(i, j - 1, grid) + dfs(i, j + 1, grid);
    }
}

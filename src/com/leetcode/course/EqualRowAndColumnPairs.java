package com.poc.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPairs {

    public static void main(String[] args) {
        EqualRowAndColumnPairs obj = new EqualRowAndColumnPairs();
        int[][] input = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        System.out.println(obj.equalPairs(input));
        System.out.println(obj.equalPairs_MoreEfficient(input));
    }

    public int equalPairs_MoreEfficient(int[][] grid) {
        HashMap<String, Integer> rowMap = new HashMap<>();
        for (int[] row : grid) {
            String rowStr = Arrays.toString(row);
            rowMap.put(rowStr, rowMap.getOrDefault(rowStr, 0) + 1);
        }
        int n = grid.length, count = 0;
        for (int i = 0; i < n; i++) {
            int[] columnArr = new int[n];
            for (int j = 0; j < n; j++) {
                columnArr[j] = grid[j][i];
            }
            String columnStr = Arrays.toString(columnArr);
            count += rowMap.getOrDefault(columnStr, 0);
        }
        return count;
    }

    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> rowMap = new HashMap<>();
        HashMap<String, Integer> columnMap = new HashMap<>();
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            StringBuilder column = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(grid[i][j]).append(',');
                column.append(grid[j][i]).append(',');
            }
            rowMap.put(row.toString(), rowMap.getOrDefault(row.toString(), 0) + 1);
            columnMap.put(column.toString(), columnMap.getOrDefault(column.toString(), 0) + 1);
        }

        int count = 0;
        for (Map.Entry<String, Integer> columnEntry : columnMap.entrySet()) {
            if (rowMap.containsKey(columnEntry.getKey())) {
                count += rowMap.get(columnEntry.getKey()) * columnEntry.getValue();
            }
        }

        return count;
    }
}

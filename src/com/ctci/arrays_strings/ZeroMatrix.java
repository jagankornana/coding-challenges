package com.ctci.arrays_strings;

import java.util.Scanner;

/* If element is 0 in m*n matrix, then make its entire row and column are set to 0, in place */

public class ZeroMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowSize, colSize;
        System.out.print("Enter number of rows: ");
        rowSize = scanner.nextInt();
        System.out.print("Enter number of cols: ");
        colSize = scanner.nextInt();
        int[][] matrix = new int[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            System.out.println("Enter rowSize" + (i + 1) + " elements:");
            for (int j = 0; j < colSize; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        printMatrix(matrix, rowSize, colSize);

        boolean rowHasZero, colHasZero;

        // check row and column have zeroes
        rowHasZero = checkRowHasZero(matrix, colSize);
        colHasZero = checkColHasZero(matrix, rowSize);

        // find zeroes in the matrix and flag them in the first row and first column
        findZeroesInMatrix(matrix, rowSize, colSize);

        // set zeroes in the row
        for (int row = 1; row < rowSize; row++) {
            if (matrix[row][0] == 0) {
                nullifyRow(matrix, colSize, row);
            }
        }

        // set zeroes in the col
        for (int col = 1; col < colSize; col++) {
            if (matrix[0][col] == 0) {
                nullifyCol(matrix, rowSize, col);
            }
        }

        if (rowHasZero) {
            nullifyRow(matrix, colSize, 0);
        }

        if (colHasZero) {
            nullifyCol(matrix, rowSize, 0);
        }

        printMatrix(matrix, rowSize, colSize);
    }

    private static boolean checkRowHasZero(int[][] matrix, int colSize) {
        for (int col = 0; col < colSize; col++) {
            if (matrix[0][col] == 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkColHasZero(int[][] matrix, int rowSize) {
        for (int row = 0; row < rowSize; row++) {
            if (matrix[row][0] == 0) {
                return true;
            }
        }
        return false;
    }

    private static void findZeroesInMatrix(int[][] matrix, int rowSize, int colSize) {
        for (int row = 1; row < rowSize; row++) {
            for (int col = 1; col < colSize; col++) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }
    }

    private static void nullifyRow(int[][] matrix, int colSize, int row) {
        for (int col = 0; col < colSize; col++) {
            matrix[row][col] = 0;
        }
    }

    private static void nullifyCol(int[][] matrix, int rowSize, int col) {
        for (int row = 0; row < rowSize; row++) {
            matrix[row][col] = 0;
        }
    }

    private static void printMatrix(int[][] matrix, int rowSize, int colSize) {
        System.out.println();
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                System.out.print(matrix[row][col] + "  ");
            }
            System.out.println();
        }
    }
}

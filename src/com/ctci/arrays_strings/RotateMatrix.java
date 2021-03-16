package com.ctci.arrays_strings;

import java.util.Scanner;

/* Rotate matrix to 90 degrees in place */

public class RotateMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter matrix size: ");
        int matrixSize = scanner.nextInt();
        int[][] pixels = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            System.out.println("Enter row" + (i + 1) + " elements:");
            for (int j = 0; j < matrixSize; j++) {
                pixels[i][j] = scanner.nextInt();
            }
        }

        rotate(pixels, matrixSize);

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                System.out.print(pixels[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private static void rotate(int[][] pixels, int matrixSize) {
        for (int layer = 0; layer < matrixSize / 2; layer++) {
            int first = layer;
            int last = matrixSize - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                // save the top layer element
                int top = pixels[first][i];
                // copy from left to top
                pixels[first][i] = pixels[last - offset][first];
                // copy from bottom to left
                pixels[last - offset][first] = pixels[last][last - offset];
                // copy from right to bottom
                pixels[last][last - offset] = pixels[i][last];
                // copy top element to right
                pixels[i][last] = top;
            }
        }
    }
}

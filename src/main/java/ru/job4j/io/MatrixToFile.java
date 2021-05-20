package ru.job4j.io;

import java.io.*;

public class MatrixToFile {
    public static int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int cell = 0; cell < size; cell++) {
                table[row][cell] = (row + 1) * (cell + 1);
            }
        }
        return table;
    }

    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("matrix.txt")) {
            PrintStream printStream = new PrintStream(out);
            int[][] matrix = multiple(9);
            for (int[] row : matrix) {
                for (int column : row) {
                    printStream.printf("%3d", column);
                }
                printStream.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

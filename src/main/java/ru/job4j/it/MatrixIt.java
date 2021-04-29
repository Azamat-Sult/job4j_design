package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        int c = column;
        for (int r = row; r < data.length; r++) {
            if (c < data[r].length) {
                return true;
            } else {
                c = 0;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        for (int r = row; r < data.length; r++) {
            if (column < data[r].length) {
                row = r;
                column++;
                return data[row][column - 1];
            } else {
                column = 0;
            }
        }
        return null;
    }
}

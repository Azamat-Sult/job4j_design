package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] data;
    private int pointer = 0;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        for (int index = pointer; index < data.length; index++) {
            if (data[index] % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        for (int index = pointer; index < data.length; index++) {
            if (data[index] % 2 == 0) {
                pointer = index;
                return data[pointer++];
            }
        }
        return null;
    }
}

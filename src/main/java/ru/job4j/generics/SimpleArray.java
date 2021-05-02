package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private T[] data;
    private int size = 0;
    private int cursor = 0;

    public SimpleArray(int length) {
        this.data = (T[]) new Object[length];
    }

    public void add(T model) {
        Objects.checkIndex(size, data.length);
        data[size++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, size);
        data[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        if (index != size - 1) {
            System.arraycopy(data, index + 1, data, index, size - index - 1);
        }
        size--;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return data[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator();
    }

    private class SimpleArrayIterator implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return data[cursor++];
        }
    }
}

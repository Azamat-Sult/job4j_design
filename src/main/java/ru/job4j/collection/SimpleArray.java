package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private int capacity = 3;
    private int incStepCapacity = 3;
    private Object[] container = new Object[capacity];
    private int size = 0;
    private int modCount = 0;

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) container[index];
    }

    public void add(T model) {
        if (size >= container.length) {
            resizeContainer();
        }
        container[size++] = model;
        modCount++;
    }

    public void resizeContainer() {
        container = Arrays.copyOf(container, capacity + incStepCapacity);
        capacity += incStepCapacity;
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator(modCount);
    }

    private class SimpleArrayIterator implements Iterator<T> {
        private int expectedModCount;
        private int cursor = 0;

        public SimpleArrayIterator(int currentModCount) {
            this.expectedModCount = currentModCount;
        }

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            return (T) container[cursor++];
        }
    }
}

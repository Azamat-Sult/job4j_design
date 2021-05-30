package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleHashMap<K, V> implements Iterable<K> {

    private final static double LOAD_FACTOR = 0.75;
    private int capacity = 2;
    private Object[] keyContainer = new Object[capacity];
    private Object[] valContainer = new Object[capacity];
    private int size = 0;
    private int modCount = 0;

    public boolean insert(K key, V value) {
        if (size >= capacity * LOAD_FACTOR) {
            resizeContainers();
        }

        int index = getIndexOf(key);

        if (keyContainer[index] == null) {
            keyContainer[index] = key;
            valContainer[index] = value;
            size++;
            modCount++;
            return true;
        }

        if (keyContainer[index] != null
                && keyContainer[index].hashCode() == key.hashCode()
                && keyContainer[index].equals(key)) {
            valContainer[index] = value;
            modCount++;
            return true;
        }

        return false;
    }

    public V get(K key) {
        int index = getIndexOf(key);
        if (keyContainer[index] != null && Objects.equals(keyContainer[index], key)) {
            return (V) valContainer[index];
        }
        return null;
    }

    public boolean delete(K key) {
        int index = getIndexOf(key);
        if (keyContainer[index] != null && Objects.equals(keyContainer[index], key)) {
            keyContainer[index] = null;
            valContainer[index] = null;
            size--;
            modCount++;
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getIndexOf(K key) {
        int hk = key.hashCode();
        return (hk ^ (hk >>> 16)) & (capacity - 1);
    }

    private void resizeContainers() {
        capacity *= 2;
        Object[] keyContainerNew = new Object[capacity];
        Object[] valContainerNew = new Object[capacity];
        for (int index = 0; index < keyContainer.length; index++) {
            if (keyContainer[index] != null) {
                int newIndex = getIndexOf((K) keyContainer[index]);
                keyContainerNew[newIndex] = keyContainer[index];
                valContainerNew[newIndex] = valContainer[index];
            }
        }
        keyContainer = keyContainerNew;
        valContainer = valContainerNew;
    }

    @Override
    public Iterator<K> iterator() {
        return new SimpleHashMapIterator(modCount);
    }

    private class SimpleHashMapIterator implements Iterator<K> {
        private int expectedModCount;
        private int cursorIndex = 0;
        private int cursor = 0;

        public SimpleHashMapIterator(int expectedModCount) {
            this.expectedModCount = expectedModCount;
        }

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }

            while (keyContainer[cursorIndex] == null && cursorIndex < capacity - 1) {
                cursorIndex++;
            }
            if (keyContainer[cursorIndex] != null) {
                cursor++;
                cursorIndex++;
                return (K) keyContainer[cursorIndex - 1];
            }
            return null;
        }
    }
}

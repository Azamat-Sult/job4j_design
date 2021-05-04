package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    private Node<E> firstNode = new Node<>(null, null, null);
    private Node<E> lastNode = new Node<>(null, null, null);
    private int size = 0;
    private int modCount;

    public SimpleLinkedList() {
        this.firstNode.setNextNode(lastNode);
        this.lastNode.setPrevNode(firstNode);
    }

    @Override
    public void add(E value) {
        lastNode.setData(value);
        Node<E> newNode = new Node<>(lastNode, null, null);
        lastNode.setNextNode(newNode);
        lastNode = newNode;
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> rsl = firstNode.getNextNode();
        for (int count = 0; count < index; count++) {
            rsl = rsl.nextNode;
        }
        return rsl.getData();
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleLinkedListIterator(modCount);
    }

    private class SimpleLinkedListIterator implements Iterator<E> {
        private int expectedModCount;
        private int cursor = 0;
        private Node<E> currentElement = firstNode;

        public SimpleLinkedListIterator(int currentModCount) {
            this.expectedModCount = currentModCount;
        }

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            currentElement = currentElement.nextNode;
            cursor++;
            return currentElement.getData();
        }
    }

    private class Node<E> {
        private E data;
        private Node<E> nextNode;
        private Node<E> prevNode;

        public Node(Node<E> prevNode, E data, Node<E> nextNode) {
            this.prevNode = prevNode;
            this.data = data;
            this.nextNode = nextNode;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode;
        }

        public Node<E> getPrevNode() {
            return prevNode;
        }

        public void setPrevNode(Node<E> prevNode) {
            this.prevNode = prevNode;
        }
    }
}

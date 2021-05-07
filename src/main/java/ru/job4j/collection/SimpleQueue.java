package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        if (out.isEmpty()) {
            reverseInToOut();
        }
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
    }

    public void reverseInToOut() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
    }
}

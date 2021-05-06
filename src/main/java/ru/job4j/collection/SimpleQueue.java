package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int countIn = 0;
    private int countOut = 0;

    public T poll() {
        if (countOut == 0) {
            reverseInToOut();
        }
        countOut--;
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        countIn++;
    }

    public void reverseInToOut() {
        while (countIn > 0) {
            out.push(in.pop());
            countOut++;
            countIn--;
        }
    }
}

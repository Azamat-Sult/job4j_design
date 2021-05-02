package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        return mem.set(mem.indexOf(findById(id)), model) != null;
    }

    @Override
    public boolean delete(String id) {
        return mem.remove(findById(id));
    }

    @Override
    public T findById(String id) {
        for (T element : mem) {
            if (element.getId().equals(id)) {
                return element;
            }
        }
        return null;
    }
}

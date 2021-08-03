package ru.job4j.ood.lsp.foodstore;

import java.util.ArrayList;
import java.util.List;

public class Store implements IStore {
    private final List<Item> store = new ArrayList<>();

    @Override
    public void addItem(Item item) {
        store.add(item);
    }

    @Override
    public Item getItem(int index) {
        return store.get(index);
    }

    @Override
    public void getReport() {
        for (int index = 0; index < store.size(); index++) {
            System.out.println("index: " + index + " , item: " + store.get(index));
        }
    }
}

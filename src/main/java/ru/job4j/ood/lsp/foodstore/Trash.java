package ru.job4j.ood.lsp.foodstore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {
    private final List<Item> store = new ArrayList<>();

    @Override
    public boolean accept(Item item) {
        return LocalDate.now().isAfter(item.getExpiryDate());
    }

    @Override
    public void addItem(Item item) {
        store.add(item);
        System.out.println(item + " - moved to trash");
    }

    @Override
    public Item getItem(int index) {
        return store.get(index);
    }

    @Override
    public List<Item> getAllItems() {
        return store;
    }

    @Override
    public void clearStore() {
        store.clear();
    }

    @Override
    public void getReport() {
        for (int index = 0; index < store.size(); index++) {
            System.out.println("index: " + index + " , item: " + store.get(index));
        }
    }
}

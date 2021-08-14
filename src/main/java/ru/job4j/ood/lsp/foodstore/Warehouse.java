package ru.job4j.ood.lsp.foodstore;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {
    private final List<Item> store = new ArrayList<>();

    @Override
    public boolean accept(Item item) {
        long expDate = ChronoUnit.DAYS.between(item.getCreateDate(), item.getExpiryDate());
        long remainingExpDate = ChronoUnit.DAYS.between(LocalDate.now(), item.getExpiryDate());
        long remainPercentOfExpDate = 100 * remainingExpDate / expDate;
        return remainPercentOfExpDate > 75;
    }

    @Override
    public void addItem(Item item) {
        store.add(item);
        System.out.println(item + " - moved to warehouse");
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

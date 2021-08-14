package ru.job4j.ood.lsp.foodstore;

import java.util.List;

public interface Store {
    boolean accept(Item item);
    void addItem(Item item);
    Item getItem(int index);
    List<Item> getAllItems();
    void clearStore();
    void getReport();
}

package ru.job4j.ood.lsp.foodstore;

public interface Store {
    boolean accept(Item item);
    void addItem(Item item);
    Item getItem(int index);
    void getReport();
}

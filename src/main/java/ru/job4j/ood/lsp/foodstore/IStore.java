package ru.job4j.ood.lsp.foodstore;

public interface IStore {
    void addItem(Item item);
    Item getItem(int index);
    void getReport();
}

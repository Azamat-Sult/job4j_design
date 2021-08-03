package ru.job4j.ood.lsp.foodstore;

import java.time.LocalDate;

public interface Item {
    String getName();
    LocalDate getCreateDate();
    LocalDate getExpiryDate();
    int getDiscount();
    void setDiscount(int percent);
}

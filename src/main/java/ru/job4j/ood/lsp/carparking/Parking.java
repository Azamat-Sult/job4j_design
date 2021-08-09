package ru.job4j.ood.lsp.carparking;

public interface Parking {
    boolean canPark(Car car);
    void park(Car car);
    void getReport();
}

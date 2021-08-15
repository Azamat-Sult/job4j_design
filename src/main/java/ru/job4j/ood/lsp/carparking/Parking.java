package ru.job4j.ood.lsp.carparking;

public interface Parking {
    Car[] getLittleCarParking();
    Car[] getBigCarParking();
    boolean canPark(Car car);
    boolean park(Car car);
    void parkAtPlace(Car car, int place, Car[] parking);
    void getReport();
}

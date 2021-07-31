package ru.job4j.ood.ocp;

public class WrongExample2 {

    // using class directly without interface

    public void checkEmployee(String name) {
        DbAccess postgresql = new DbAccess();
    }
}

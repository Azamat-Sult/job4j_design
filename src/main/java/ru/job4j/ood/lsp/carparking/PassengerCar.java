package ru.job4j.ood.lsp.carparking;

public class PassengerCar implements Car {

    private int size = 1;
    private String model;
    private String gNumber;

    public PassengerCar(String model, String gNumber) {
        this.model = model;
        this.gNumber = gNumber;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getGNumber() {
        return gNumber;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "PassengerCar { " + "size=" + size
                + ", model='" + model + '\'' + ", gNumber='" + gNumber + '\'' + " }";
    }
}

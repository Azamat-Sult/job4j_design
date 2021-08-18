package ru.job4j.ood.lsp.carparking;

public class TruckCar implements Car {

    private int size;
    private String model;
    private String gNumber;

    public TruckCar(int size, String model, String gNumber) {
        this.size = size;
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

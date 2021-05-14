package ru.job4j.map;

import java.util.Objects;

public class Car {
    private String model;
    private String color;
    private String idNumber;
    private boolean wasInAccident;

    public Car(String model, String color, String idNumber, boolean wasInAccident) {
        this.model = model;
        this.color = color;
        this.idNumber = idNumber;
        this.wasInAccident = wasInAccident;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public boolean isWasInAccident() {
        return wasInAccident;
    }

    public void setWasInAccident(boolean wasInAccident) {
        this.wasInAccident = wasInAccident;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return wasInAccident == car.wasInAccident && Objects.equals(model, car.model) && Objects.equals(color, car.color) && Objects.equals(idNumber, car.idNumber);
    }

    @Override
    public int hashCode() {
        //return Objects.hash(model, color, idNumber, wasInAccident);
        return Objects.hash(model, color, idNumber); // без wasInAccident для тестирования коллизий
    }
}

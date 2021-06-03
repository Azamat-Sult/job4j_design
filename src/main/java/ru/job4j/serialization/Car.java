package ru.job4j.serialization;

import java.util.Arrays;

public class Car {
    private boolean wasInAccident;
    private int age;
    private String model;
    private Engine engine;
    private String[] equipment;

    public Car() {
    }

    public Car(boolean wasInAccident, int age, String model, Engine engine, String... equipment) {
        this.wasInAccident = wasInAccident;
        this.age = age;
        this.model = model;
        this.engine = engine;
        this.equipment = equipment;
    }

    public boolean isWasInAccident() {
        return wasInAccident;
    }

    public int getAge() {
        return age;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public String[] getEquipment() {
        return equipment;
    }

    @Override
    public String toString() {
        return "Car{"
                + "wasInAccident=" + wasInAccident
                + ", age=" + age
                + ", model='" + model + '\''
                + ", engine=" + engine
                + ", equipment=" + Arrays.toString(equipment) + '}';
    }
}

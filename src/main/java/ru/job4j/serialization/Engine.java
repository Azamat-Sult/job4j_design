package ru.job4j.serialization;

public class Engine {
    private int power;
    private double volumeLitres;
    private int numOfValves;

    public Engine() {
    }

    public Engine(int power, double volumeLitres, int numOfValves) {
        this.power = power;
        this.volumeLitres = volumeLitres;
        this.numOfValves = numOfValves;
    }

    public int getPower() {
        return power;
    }

    public double getVolumeLitres() {
        return volumeLitres;
    }

    public int getNumOfValves() {
        return numOfValves;
    }

    @Override
    public String toString() {
        return "Engine{"
                + "power=" + power
                + ", volumeLitres=" + volumeLitres
                + ", numOfValves=" + numOfValves + '}';
    }
}

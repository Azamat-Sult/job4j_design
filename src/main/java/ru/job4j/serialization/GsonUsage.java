package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUsage {
    public static void main(String[] args) {
        final Car car = new Car(false, 6, "Logan",
                new Engine(90, 1.6, 8), "Audio", "Security alarm");

        final Gson gson = new GsonBuilder().create();
        String carInJSON = gson.toJson(car);
        System.out.println(carInJSON);

        System.out.println("---------------------------------");

        final Car carFromJSON = gson.fromJson(carInJSON, Car.class);
        System.out.println(carFromJSON);
    }
}

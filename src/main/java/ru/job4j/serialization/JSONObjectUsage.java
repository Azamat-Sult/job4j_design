package ru.job4j.serialization;

import org.json.JSONObject;

public class JSONObjectUsage {
    public static void main(String[] args) {
        final Engine engine = new Engine(90, 1.6, 8);
        final Car car = new Car(false, 6, "Logan",
                engine, "Audio", "Security alarm");

        JSONObject engineJSONObj = new JSONObject(engine);
        JSONObject carJSONObj = new JSONObject(car);

        String engineJSONStr = engineJSONObj.toString();
        String carJSONStr = carJSONObj.toString();

        System.out.println(engineJSONStr);
        System.out.println(carJSONStr);
    }
}

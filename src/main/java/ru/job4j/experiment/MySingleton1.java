package ru.job4j.experiment;

public class MySingleton1 {

    private static MySingleton1 instance;

    private MySingleton1() {
    }

    public static MySingleton1 getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new MySingleton1();
        return instance;
    }

}
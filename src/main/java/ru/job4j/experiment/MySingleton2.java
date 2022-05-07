package ru.job4j.experiment;

public class MySingleton2 {

    private MySingleton2() {
    }

    private static class SingletonHolder {
        public static final MySingleton2 INSTANCE = new MySingleton2();
    }

    public static MySingleton2 getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
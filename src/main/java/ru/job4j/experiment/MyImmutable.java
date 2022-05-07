package ru.job4j.experiment;

import java.util.List;

public final class MyImmutable {

    private final int age;

    private final List<String> addresses;

    public MyImmutable(int age, List<String> addresses) {
        this.age = age;
        this.addresses = List.copyOf(addresses);
    }

    public int getAge() {
        return age;
    }

    public List<String> getAddresses() {
        return addresses;
    }

}
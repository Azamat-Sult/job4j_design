package ru.job4j.experiment;

import java.util.Objects;

public class MyEquals {

    private int age;

    private String name;

    /*public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MyEquals obj = (MyEquals) o;
        if (age == obj.age && Objects.equals(name, obj.name)) {
            return true;
        } else {
            return false;
        }
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MyEquals myEquals = (MyEquals) o;
        return age == myEquals.age && Objects.equals(name, myEquals.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

}
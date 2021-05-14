package ru.job4j.map;

public class CarOwner {
    private String fullName;
    private int passport;

    public CarOwner(String fullName, int passport) {
        this.fullName = fullName;
        this.passport = passport;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPassport() {
        return passport;
    }

    public void setPassport(int passport) {
        this.passport = passport;
    }
}

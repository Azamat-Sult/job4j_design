package ru.job4j.gc;

import java.util.Objects;

public class User {

    private int id;

    private String name;

    private Boolean flag;

    public User(int id, String name, Boolean flag) {
        this.id = id;
        this.name = name;
        this.flag = flag;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %s%n", name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(flag, user.flag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, flag);
    }
}

package ru.job4j.kiss;

public class User implements Comparable<User> {
    private int id;
    private String name;
    private String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User {" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + '}';
    }

    @Override
    public int compareTo(User another) {
        return Integer.compare(id, another.id);
    }

}

package ru.job4j.ood.lsp.foodstore;

import java.time.LocalDate;
import java.util.Objects;

public class Food implements Item {
    private String name;
    private LocalDate createDate;
    private LocalDate expiryDate;
    private double price;
    private int discountPercent;

    public Food(String name, LocalDate createDate,
                LocalDate expiryDate, double price, int discount) {
        this.name = name;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.price = price;
        this.discountPercent = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discountPercent;
    }

    public void setDiscount(int discount) {
        this.discountPercent = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return Double.compare(food.price, price) == 0
                && Double.compare(food.discountPercent, discountPercent) == 0
                && Objects.equals(name, food.name)
                && Objects.equals(createDate, food.createDate)
                && Objects.equals(expiryDate, food.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, createDate, expiryDate, price, discountPercent);
    }

    @Override
    public String toString() {
        return "Food{ " + "name='" + name + '\'' + ", createDate=" + createDate
                + ", expiryDate=" + expiryDate + ", price=" + price + ", discount=" + discountPercent + " }";
    }
}

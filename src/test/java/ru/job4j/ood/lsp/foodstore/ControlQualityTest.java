package ru.job4j.ood.lsp.foodstore;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ControlQualityTest {

    @Test
    public void whenSorted() {

        System.out.println("Sorting test");

        ArrayList<Item> goods = new ArrayList<>();

        Item sugar = new Food("Sugar", LocalDate.of(2021, Month.AUGUST, 1),
                LocalDate.of(2021, Month.OCTOBER, 1), 60, 0);

        Item butter = new Food("Butter", LocalDate.of(2021, Month.JULY, 3),
                LocalDate.of(2021, Month.SEPTEMBER, 3), 120, 0);

        Item milk = new Food("Milk", LocalDate.of(2021, Month.JULY, 14),
                LocalDate.of(2021, Month.AUGUST, 14), 48, 0);

        Item bread = new Food("Bread", LocalDate.of(2021, Month.AUGUST, 3),
                LocalDate.of(2021, Month.AUGUST, 4), 24, 0);


        goods.add(sugar);
        goods.add(butter);
        goods.add(milk);
        goods.add(bread);

        ArrayList<Store> stores = new ArrayList<>();

        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();

        stores.add(warehouse);
        stores.add(shop);
        stores.add(trash);

        ControlQuality depCQ = new ControlQuality(goods, stores);

        System.out.println("------- Sorting goods -------");
        depCQ.sortGoods();

        assertThat(warehouse.getItem(0), is(sugar));

        assertThat(shop.getItem(0), is(butter));
        assertThat(shop.getItem(0).getDiscount(), is(0));

        assertThat(shop.getItem(1), is(milk));
        assertThat(shop.getItem(1).getDiscount(), is(30));

        assertThat(trash.getItem(0), is(bread));

    }

    @Test
    public void whenReSorted() {

        System.out.println("Resorting test");

        Item sugar = new Food("Sugar", LocalDate.of(2021, Month.AUGUST, 1),
                LocalDate.of(2021, Month.OCTOBER, 1), 60, 0);

        Item butter = new Food("Butter", LocalDate.of(2021, Month.JULY, 3),
                LocalDate.of(2021, Month.SEPTEMBER, 3), 120, 0);

        Item milk = new Food("Milk", LocalDate.of(2021, Month.JULY, 14),
                LocalDate.of(2021, Month.AUGUST, 14), 48, 0);

        Item bread = new Food("Bread", LocalDate.of(2021, Month.AUGUST, 3),
                LocalDate.of(2021, Month.AUGUST, 4), 24, 0);

        ArrayList<Item> goods = new ArrayList<>();

        ArrayList<Store> stores = new ArrayList<>();

        Store warehouse = new Warehouse();
        warehouse.addItem(bread);
        warehouse.addItem(milk);

        Store shop = new Shop();
        shop.addItem(butter);

        Store trash = new Trash();
        trash.addItem(sugar);

        stores.add(warehouse);
        stores.add(shop);
        stores.add(trash);

        ControlQuality depCQ = new ControlQuality(goods, stores);

        System.out.println("------- Resorting goods -------");
        depCQ.reSortGoods();

        assertThat(warehouse.getItem(0), is(sugar));

        assertThat(shop.getItem(1), is(butter));
        assertThat(shop.getItem(1).getDiscount(), is(0));

        assertThat(shop.getItem(0), is(milk));
        assertThat(shop.getItem(0).getDiscount(), is(30));

        assertThat(trash.getItem(0), is(bread));

    }

}
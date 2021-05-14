package ru.job4j.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {

    @Test
    public void whenAddThenGet() {
        SimpleHashMap<Car, CarOwner> catalogue = new SimpleHashMap<>();
        Car car1 = new Car("Renault Logan 2", "blue", "x999xx99", false);
        CarOwner owner1 = new CarOwner("Azamat", 1234123456);
        assertTrue(catalogue.insert(car1, owner1));
        assertThat(catalogue.get(car1), is(owner1));
    }

    @Test
    public void whenAddThenGetWrongKey() {
        SimpleHashMap<Car, CarOwner> catalogue = new SimpleHashMap<>();
        Car car1 = new Car("Renault Logan 2", "blue", "x999xx99", false);
        CarOwner owner1 = new CarOwner("Azamat", 1234123456);
        Car car2 = new Car("BMW", "black", "x333xx33", true);
        CarOwner owner2 = new CarOwner("Ivan", 1234123456);
        assertTrue(catalogue.insert(car1, owner1));
        assertNull(catalogue.get(car2));
    }

    @Test
    public void whenEmptyThenGet() {
        SimpleHashMap<Car, CarOwner> catalogue = new SimpleHashMap<>();
        Car car1 = new Car("Renault Logan 2", "blue", "x999xx99", false);
        CarOwner owner1 = new CarOwner("Azamat", 1234123456);
        assertNull(catalogue.get(car1));
    }

    @Test
    public void whenAddThenDel() {
        SimpleHashMap<Car, CarOwner> catalogue = new SimpleHashMap<>();
        Car car1 = new Car("Renault Logan 2", "blue", "x999xx99", false);
        CarOwner owner1 = new CarOwner("Azamat", 1234123456);
        assertTrue(catalogue.insert(car1, owner1));
        assertTrue(catalogue.delete(car1));
        assertNull(catalogue.get(car1));
    }

    @Test
    public void whenAddThenCollision() {
        SimpleHashMap<Car, CarOwner> catalogue = new SimpleHashMap<>();
        Car car1 = new Car("Renault Logan 2", "blue", "x999xx99", false);
        CarOwner owner1 = new CarOwner("Azamat", 1234123456);
        Car car2 = new Car("Renault Logan 2", "blue", "x999xx99", true);
        CarOwner owner2 = new CarOwner("Ivan", 1234123456);
        assertTrue(catalogue.insert(car1, owner1));
        assertFalse(catalogue.insert(car2, owner2));
    }

    @Test
    public void whenAddSameKeyThenReplace() {
        SimpleHashMap<Car, CarOwner> catalogue = new SimpleHashMap<>();
        Car car1 = new Car("Renault Logan 2", "blue", "x999xx99", false);
        CarOwner owner1 = new CarOwner("Azamat", 1234123456);
        Car car2 = new Car("Renault Logan 2", "blue", "x999xx99", false);
        CarOwner owner2 = new CarOwner("Ivan", 1234123456);
        assertTrue(catalogue.insert(car1, owner1));
        assertTrue(catalogue.insert(car2, owner2));
        assertThat(catalogue.get(car1), is(owner2));
    }

    @Test
    public void whenAddAndResizeThenGet() {
        SimpleHashMap<Car, CarOwner> catalogue = new SimpleHashMap<>();
        Car car1 = new Car("Renault Logan 2", "blue", "x999xx99", false);
        CarOwner owner1 = new CarOwner("Azamat", 1234123456);
        Car car2 = new Car("VAZ1", "red", "x888xx88", false);
        CarOwner owner2 = new CarOwner("Ivan", 1234654321);
        Car car3 = new Car("UAZ122", "white", "x555xx55", true);
        CarOwner owner3 = new CarOwner("Egor", 1234765432);
        assertTrue(catalogue.insert(car1, owner1));
        assertTrue(catalogue.insert(car2, owner2));
        assertTrue(catalogue.insert(car3, owner3));
        assertThat(catalogue.get(car1), is(owner1));
        assertThat(catalogue.get(car2), is(owner2));
        assertThat(catalogue.get(car3), is(owner3));
    }

    @Test
    public void whenAddThenHasNext() {
        SimpleHashMap<Car, CarOwner> catalogue = new SimpleHashMap<>();
        Car car1 = new Car("Renault Logan 2", "blue", "x999xx99", false);
        CarOwner owner1 = new CarOwner("Azamat", 1234123456);
        assertTrue(catalogue.insert(car1, owner1));
        Iterator<Car> catalogueIterator = catalogue.iterator();
        assertTrue(catalogueIterator.hasNext());
        assertTrue(catalogueIterator.hasNext());
        assertTrue(catalogueIterator.hasNext());
    }

    @Test
    public void whenEmptyThenHasNotNext() {
        SimpleHashMap<Car, CarOwner> catalogue = new SimpleHashMap<>();
        Iterator<Car> catalogueIterator = catalogue.iterator();
        assertFalse(catalogueIterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmptyAndIterateThenException() {
        SimpleHashMap<Car, CarOwner> catalogue = new SimpleHashMap<>();
        Iterator<Car> catalogueIterator = catalogue.iterator();
        catalogueIterator.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddIterateAddThenException() {
        SimpleHashMap<Car, CarOwner> catalogue = new SimpleHashMap<>();
        Car car1 = new Car("Renault Logan 2", "blue", "x999xx99", false);
        CarOwner owner1 = new CarOwner("Azamat", 1234123456);
        assertTrue(catalogue.insert(car1, owner1));
        Iterator<Car> catalogueIterator = catalogue.iterator();
        Car car2 = new Car("VAZ1", "red", "x888xx88", false);
        CarOwner owner2 = new CarOwner("Ivan", 1234654321);
        assertTrue(catalogue.insert(car2, owner2));
        catalogueIterator.next();
    }

    @Test
    public void whenAddAddIterateThenNextNextHasNotNext() {
        SimpleHashMap<Car, CarOwner> catalogue = new SimpleHashMap<>();
        Car car1 = new Car("Renault Logan 2", "blue", "x999xx99", false);
        CarOwner owner1 = new CarOwner("Azamat", 1234123456);
        assertTrue(catalogue.insert(car1, owner1));
        Car car2 = new Car("VAZ1", "red", "x888xx88", false);
        CarOwner owner2 = new CarOwner("Ivan", 1234654321);
        assertTrue(catalogue.insert(car2, owner2));
        Iterator<Car> catalogueIterator = catalogue.iterator();
        assertThat(catalogueIterator.next(), is(car1));
        assertThat(catalogueIterator.next(), is(car2));
        assertFalse(catalogueIterator.hasNext());
    }

}
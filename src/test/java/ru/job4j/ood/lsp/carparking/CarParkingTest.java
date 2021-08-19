package ru.job4j.ood.lsp.carparking;

import org.junit.Test;
import static org.junit.Assert.*;

public class CarParkingTest {

    @Test
    public void whenHaveOneEmptyPlaceOnBigCarParkingThenCanPark() {
        Car bmw = new TruckCar(2, "bmw", "b222bb77rus");
        Parking carParking = new CarParking(0, 2);
        assertTrue(carParking.canPark(bmw));
        assertTrue(carParking.park(bmw));
        carParking.getReport();
    }

    @Test
    public void whenHaveNotEmptyPlaceOnBigCarParkingThenCantPark1() {
        Car bmw = new TruckCar(2, "bmw", "b222bb77rus");
        Parking carParking = new CarParking(0, 0);
        assertFalse(carParking.canPark(bmw));
        carParking.getReport();
    }

    @Test
    public void whenHaveNotEmptyPlaceOnBigCarParkingThenCantPark2() {
        Car bmw = new TruckCar(2, "bmw", "b222bb77rus");
        Car mercedes = new TruckCar(2, "mercedes", "c333cc77rus");
        Parking carParking = new CarParking(0, 2);
        assertTrue(carParking.park(mercedes));
        assertFalse(carParking.canPark(bmw));
        carParking.getReport();
    }

    @Test
    public void whenHave2EmptyPlacesOnLittleCarParkingThenCanPark() {
        Car bmw = new TruckCar(2, "bmw", "b222bb77rus");
        Parking carParking = new CarParking(2, 0);
        assertTrue(carParking.canPark(bmw));
        assertTrue(carParking.park(bmw));
        carParking.getReport();
    }

    @Test
    public void whenHave1of2BusyPlacesOnLittleCarParkingThenCantPark1() {
        Car lada = new PassengerCar("lada", "a111aa77rus");
        Car bmw = new TruckCar(2, "bmw", "b222bb77rus");
        Parking carParking = new CarParking(2, 0);
        carParking.parkAtPlace(lada, 0, carParking.getLittleCarParking());
        assertFalse(carParking.canPark(bmw));
        carParking.getReport();
    }

    @Test
    public void whenHave1of2BusyPlacesOnLittleCarParkingThenCantPark2() {
        Car lada = new PassengerCar("lada", "a111aa77rus");
        Car bmw = new TruckCar(2, "bmw", "b222bb77rus");
        Parking carParking = new CarParking(2, 0);
        carParking.parkAtPlace(lada, 1, carParking.getLittleCarParking());
        assertFalse(carParking.canPark(bmw));
        carParking.getReport();
    }

    @Test
    public void whenHave1of3BusyPlacesOnLittleCarParkingThenCanPark1() {
        Car lada = new PassengerCar("lada", "a111aa77rus");
        Car bmw = new TruckCar(2, "bmw", "b222bb77rus");
        Parking carParking = new CarParking(3, 0);
        carParking.parkAtPlace(lada, 0, carParking.getLittleCarParking());
        assertTrue(carParking.canPark(bmw));
        assertTrue(carParking.park(bmw));
        carParking.getReport();
    }

    @Test
    public void whenHave1of3BusyPlacesOnLittleCarParkingThenCanPark2() {
        Car lada = new PassengerCar("lada", "a111aa77rus");
        Car bmw = new TruckCar(2, "bmw", "b222bb77rus");
        Parking carParking = new CarParking(3, 0);
        carParking.parkAtPlace(lada, 2, carParking.getLittleCarParking());
        assertTrue(carParking.canPark(bmw));
        assertTrue(carParking.park(bmw));
        carParking.getReport();
    }

    @Test
    public void whenHave1of3BusyPlacesOnLittleCarParkingThenCantPark() {
        Car lada = new PassengerCar("lada", "a111aa77rus");
        Car bmw = new TruckCar(2, "bmw", "b222bb77rus");
        Parking carParking = new CarParking(3, 0);
        carParking.parkAtPlace(lada, 1, carParking.getLittleCarParking());
        assertFalse(carParking.canPark(bmw));
        carParking.getReport();
    }

    @Test
    public void whenCarParkingSizeLessCarSizeThenCantPark() {
        Car bmw = new TruckCar(2, "bmw", "b222bb77rus");
        Parking carParking = new CarParking(1, 1);
        assertFalse(carParking.canPark(bmw));
        carParking.getReport();
    }

    @Test
    public void whenOnePlaceIsBusyThenCanPark1() {
        Car mercedes = new PassengerCar("mercedes", "a111aa77rus");
        Car bmw = new PassengerCar("bmw", "b222bb77rus");
        Parking carParking = new CarParking(2, 2);
        carParking.park(mercedes);
        assertTrue(carParking.canPark(bmw));
        assertTrue(carParking.park(bmw));
        carParking.getReport();
    }

    @Test
    public void whenOnePlaceIsBusyThenCanPark2() {
        Car mercedes = new PassengerCar("mercedes", "a111aa77rus");
        Car bmw = new PassengerCar("bmw", "b222bb77rus");
        Parking carParking = new CarParking(2, 2);
        carParking.parkAtPlace(mercedes, 1, carParking.getLittleCarParking());
        assertTrue(carParking.canPark(bmw));
        assertTrue(carParking.park(bmw));
        carParking.getReport();
    }

    @Test
    public void whenOnePlaceIsBusyThenCanPark3() {
        Car mercedes = new TruckCar(3, "mercedes", "a111aa77rus");
        Car bmw = new TruckCar(2, "bmw", "b222bb77rus");
        Parking carParking = new CarParking(5, 0);
        carParking.park(mercedes);
        assertTrue(carParking.canPark(bmw));
        assertTrue(carParking.park(bmw));
        carParking.getReport();
    }

    @Test
    public void whenOnePlaceIsBusyThenCanPark4() {
        Car mercedes = new TruckCar(3, "mercedes", "a111aa77rus");
        Car bmw = new TruckCar(2, "bmw", "b222bb77rus");
        Parking carParking = new CarParking(5, 0);
        carParking.parkAtPlace(mercedes, 2, carParking.getLittleCarParking());
        carParking.parkAtPlace(mercedes, 3, carParking.getLittleCarParking());
        carParking.parkAtPlace(mercedes, 4, carParking.getLittleCarParking());
        assertTrue(carParking.canPark(bmw));
        assertTrue(carParking.park(bmw));
        carParking.getReport();
    }

    @Test
    public void whenHaveOnePlaceOnBigCarParkingThenCantPark() {
        Car mercedes = new PassengerCar("mercedes", "a111aa77rus");
        Parking carParking = new CarParking(0, 1);
        assertFalse(carParking.canPark(mercedes));
        carParking.getReport();
    }
}

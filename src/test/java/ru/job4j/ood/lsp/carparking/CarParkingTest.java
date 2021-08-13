package ru.job4j.ood.lsp.carparking;

import org.junit.Test;
import static org.junit.Assert.*;

public class CarParkingTest {

    @Test
    public void whenCarParkingSizeEqualCarSizeThenCanPark() {
        Car bmw = new TruckCar(2, "bmw", "b222bb77rus");
        Parking carParking = new CarParking(2);
        assertTrue(carParking.canPark(bmw));
    }

    @Test
    public void whenCarParkingSizeLessCarSizeThenCantPark() {
        Car bmw = new TruckCar(2, "bmw", "b222bb77rus");
        Parking carParking = new CarParking(1);
        assertFalse(carParking.canPark(bmw));
    }

    @Test
    public void whenOnePlaceIsBusyThenCantPark1() {
        Car mercedes = new PassengerCar("mercedes", "a111aa77rus");
        Car bmw = new TruckCar(2, "bmw", "b222bb77rus");
        Parking carParking = new CarParking(2);
        carParking.park(mercedes);
        assertFalse(carParking.canPark(bmw));
    }

    @Test
    public void whenOnePlaceIsBusyThenCantPark2() {
        Car mercedes = new PassengerCar("mercedes", "a111aa77rus");
        Car bmw = new TruckCar(2, "bmw", "b222bb77rus");
        Parking carParking = new CarParking(2);
        carParking.parkAtPlace(mercedes, 1);
        assertFalse(carParking.canPark(bmw));
    }

    @Test
    public void whenOnePlaceIsBusyThenCanPark() {
        Car mercedes = new PassengerCar( "mercedes", "a111aa77rus");
        Car bmw = new TruckCar(2, "bmw", "b222bb77rus");
        Parking carParking = new CarParking(3);
        carParking.park(mercedes);
        assertTrue(carParking.canPark(bmw));
    }

    @Test
    public void whenTwoCarsParkedThenCantPark() {
        Car mercedes = new PassengerCar( "mercedes", "a111aa77rus");
        Car lada = new PassengerCar( "lada", "c333cc77rus");
        Car bmw = new TruckCar(2, "bmw", "b222bb77rus");
        Parking carParking = new CarParking(3);

        assertTrue(carParking.canPark(mercedes));
        carParking.parkAtPlace(mercedes, 0);

        assertTrue(carParking.canPark(lada));
        carParking.parkAtPlace(lada, 2);

        assertFalse(carParking.canPark(bmw));
        carParking.getReport();
    }

}

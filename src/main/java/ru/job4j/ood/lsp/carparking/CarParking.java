package ru.job4j.ood.lsp.carparking;

public class CarParking implements Parking {
    private final Car[] littleCarParking;
    private final Car[] bigCarParking;

    public CarParking(int sizeOfLittleCarParking, int sizeOfBigCarParking) {
        this.littleCarParking = new Car[sizeOfLittleCarParking];
        this.bigCarParking = new Car[sizeOfBigCarParking];
    }

    public Car[] getLittleCarParking() {
        return littleCarParking;
    }

    public Car[] getBigCarParking() {
        return bigCarParking;
    }

    @Override
    public boolean canPark(Car car) {
        boolean rsl;
        int carSize = car.getSize();
        if (carSize == 1) {
            rsl = canParkOnParking(carSize, littleCarParking);
        } else {
            rsl = canParkOnParking(carSize, bigCarParking);
            if (!rsl) {
                rsl = canParkOnParking(carSize, littleCarParking);
            }
        }
        return rsl;
    }

    @Override
    public boolean park(Car car) {
        boolean rsl;
        if (car.getSize() == 1) {
            rsl = parkAtParking(car, littleCarParking);
        } else {
            rsl = parkAtParking(car, bigCarParking);
            if (!rsl) {
                rsl = parkAtParking(car, littleCarParking);
            }
        }
        return rsl;
    }

    private boolean placeIsEmpty(int index, int size, Car[] parking) {
        boolean placeIsEmpty = true;
        for (int place = index; place < index + size; place++) {
            if (parking[place] != null) {
                placeIsEmpty = false;
                break;
            }
        }
        return placeIsEmpty;
    }

    private boolean canParkOnParking(int carSize, Car[] parking) {
        boolean rsl = false;
        if (carSize <= parking.length) {
            for (int index = 0; index <= parking.length - carSize; index++) {
                if (placeIsEmpty(index, carSize, parking)) {
                    rsl = true;
                    break;
                }
            }
        }
        return rsl;
    }

    private boolean parkAtParking(Car car, Car[] parking) {
        boolean rsl = false;
        int carSize = car.getSize();
        if (carSize <= parking.length) {
            for (int index = 0; index <= parking.length - carSize; index++) {
                if (placeIsEmpty(index, carSize, parking)) {
                    for (int park = index; park < index + carSize; park++) {
                        parking[park] = car;
                    }
                    rsl = true;
                    break;
                }
            }
        }
        return rsl;
    }

    public void parkAtPlace(Car car, int place, Car[] parking) {
        parking[place] = car;
    }

    @Override
    public void getReport() {
        System.out.println("----- Report for little cars parking -----");
        for (int index = 0; index < littleCarParking.length; index++) {
            System.out.println("Place " + index + " " + littleCarParking[index]);
        }
        System.out.println("----- Report for big cars parking -----");
        for (int index = 0; index < bigCarParking.length; index++) {
            System.out.println("Place " + index + " " + bigCarParking[index]);
        }
    }
}

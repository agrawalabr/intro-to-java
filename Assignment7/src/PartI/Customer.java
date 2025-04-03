package PartI;

import java.util.*;

public class Customer {
    private static int nextId = 1;
    private final int id;
    private final String name;
    private final Set<Integer> carsRented;

    public Customer(String name) {
        this.id = nextId++;
        this.name = name;
        this.carsRented = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void rentCar(int carId) {
        carsRented.add(carId);
    }

    public void returnCar(int carId) {
        carsRented.remove(carId);
    }

    public Set<Integer> getCarsRented() {
        return carsRented;
    }

    public Set<RentalCar> getRentalCarsForCustomer(RentalCar[] allCars) {
        Set<RentalCar> rentedCarsByPatron = new HashSet<>();
        for (RentalCar car : allCars) {
            if (car != null && carsRented.contains(car.getId())) {
                rentedCarsByPatron.add(car);
            }
        }
        return rentedCarsByPatron;
    }

}

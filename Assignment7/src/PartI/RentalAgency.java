package PartI;

import java.util.*;

public class RentalAgency {
    private final String name;
    private final String city;
    private final String state;
    private final Map<Integer, RentalCar> rentalCars;
    private final Set<Integer> rented;
    private static final int CAPACITY = 10;
    private int carCount;

    public RentalAgency(String name, String city, String state) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.rentalCars = new HashMap<>();
        this.rented = new HashSet<>();
        this.carCount = 0;
    }
    
    public String getName() {
    		return this.name;
        }

    public String getCity() {
		return this.city;
    }
   
    public String getState() {
		return this.state;
    }

    public RentalCar[] getCars() {
        RentalCar[] allCars = new RentalCar[CAPACITY];
        int index = 0;
        for (RentalCar car : rentalCars.values()) {
            allCars[index++] = car;
        }
        return allCars;
    }
    
    public RentalCar[] carsInStock() {
        List<RentalCar> availableCars = new ArrayList<>();
        for (RentalCar car : rentalCars.values()) {
            if (!rented.contains(car.getId())) {
                availableCars.add(car);
            }
        }
        return availableCars.toArray(new RentalCar[0]);
    }
    
    public int totalRentalCars() {
    	return carCount;
    }

    public RentalCar rentCar(int id, int days) {
        RentalCar carToRent = rentalCars.get(id);

        if (carToRent == null || rented.contains(id)) {
            return null;
        }
        rented.add(id);
        return carToRent;
    }

    public double returnCar(int id, int days) {
        RentalCar returnedCar = rentalCars.get(id);
        if (returnedCar == null || !rented.contains(id)) {
            return -1;
        }
        rented.remove(id);
        return returnedCar.getDailyCost() * days;
    }
    
    public boolean addCar(RentalCar car) {
        if (carCount >= CAPACITY) {
            return false;
        }
        rentalCars.put(car.getId(), car);
        carCount++;
        return true;
    }
    
    public boolean removeCar(int id) {
        if (rented.contains(id)) {
            return false;
        }
        if (rentalCars.remove(id) != null) {
            carCount--;
            return true;
        }
        return false;
    }
    
    public List<RentalCar> getRentedCars() {
        List<RentalCar> allCars = new ArrayList<>();
        for (RentalCar car : getCars()) {
            if (car != null) {
                allCars.add(car); 
            }
        }
        List<RentalCar> availableCars = Arrays.asList(carsInStock());
        Set<RentalCar> rentedCars = new HashSet<>(allCars);
        rentedCars.removeAll(availableCars); 
        return new ArrayList<>(rentedCars); 
    }
    
	public static void main(String[] args) {
        RentalAgency agency = new RentalAgency("City Rentals", "New York", "NY");
        RentalCar car1 = new RentalCar("Toyota", "Corolla", 2020, 50.99);
        RentalCar car2 = new RentalCar("Honda", "Civic", 2021, 55.50);
        RentalCar car3 = new RentalCar("Ford", "Focus", 2019, 48.0);
        RentalCar car4 = new RentalCar("Lamborghini", "Aventador", 2012, 150.50);
        
        agency.addCar(car1);
        agency.addCar(car2);
        agency.addCar(car3);
        agency.addCar(car4);

        Customer cust1 = new Customer("Abhishek Agrawal");
        Customer cust2 = new Customer("Khushi Agrawal");
        Customer cust3 = new Customer("Rohini Agrawal");
        
        cust1.rentCar(car1.getId());
        cust1.rentCar(car4.getId());
        cust2.rentCar(car2.getId());

        if (agency.rentCar(car1.getId(), 5) != null) {
            cust1.rentCar(car1.getId());
        }
        if (agency.rentCar(car4.getId(), 3) != null) {
            cust1.rentCar(car4.getId());  
        }
        if (agency.rentCar(car2.getId(), 6) != null) {
            cust2.rentCar(car2.getId());  
        }

        System.out.println("Cars currently rented out by customers:");
        for (RentalCar car : agency.getRentedCars()) {
            System.out.println(car.getMake() + " " + car.getModel());
        }

        System.out.println("\nCars rented by " + cust1.getName() + " specifically:");
        for (RentalCar car : cust1.getRentalCarsForCustomer(agency.getCars())) {
            System.out.println(car.getMake() + " " + car.getModel());
        }

        System.out.println("\nCars available for rent with Agency:");
        for (RentalCar car : agency.carsInStock()) {
            System.out.println(car.getMake() + " " + car.getModel());
        }
	}
}

class RentalCar {
    private static int nextId = 1;
    private final int id;
    private final String make;
    private final String model;
    private final int year;
    private double dailyCost;

    public RentalCar(String make, String model, int year, double dailyCost) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.dailyCost = dailyCost;
        this.id = nextId++;
    }
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public double getDailyCost() {
        return dailyCost;
    }
    public void setDailyCost(double dailyCost) {
        this.dailyCost = dailyCost;
    }
    public int getId() {
        return id;
    }
}
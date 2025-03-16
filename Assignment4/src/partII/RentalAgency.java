package partII;

import java.util.ArrayList;

public class RentalAgency {
    private String name;
    private String city;
    private String state;
    private static final int CAPACITY = 10;
    private ArrayList<Vehicle> rentalVehicles;
    private ArrayList<Vehicle> rentedVehicles;

    public RentalAgency(String name, String city, String state) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.rentalVehicles = new ArrayList<>();
        this.rentedVehicles = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public ArrayList<Vehicle> getVehicles() { return new ArrayList<>(rentalVehicles); }

    public int totalRentalVehicles() {
        return rentalVehicles.size();
    }

    public Vehicle rentVehicle(int id) {
        for (Vehicle v : rentalVehicles) {
            if (v.getId() == id) {
                rentalVehicles.remove(v);
                rentedVehicles.add(v);
                return v;
            }
        }
        return null;
    }

    public Vehicle rentVehicle(Vehicle vehicle) {
        if (rentalVehicles.contains(vehicle)) {
            rentalVehicles.remove(vehicle);
            rentedVehicles.add(vehicle);
            return vehicle;
        }
        return null;
    }

    public double returnVehicle(int id, int days) {
        for (Vehicle v : rentedVehicles) {
            if (v.getId() == id) {
                rentedVehicles.remove(v);
                rentalVehicles.add(v);
                return v.getDailyCost() * days;
            }
        }
        return -1;
    }

    public double returnVehicle(Vehicle vehicle, int days) {
        if (rentedVehicles.contains(vehicle)) {
            rentedVehicles.remove(vehicle);
            rentalVehicles.add(vehicle);
            return vehicle.getDailyCost() * days;
        }
        return -1;
    }

    public boolean addVehicle(Vehicle vehicle) {
        if (rentalVehicles.size() < CAPACITY) {
            return rentalVehicles.add(vehicle);
        }
        return false;
    }

    public boolean removeVehicle(int id) {
        return rentalVehicles.removeIf(v -> v.getId() == id);
    }

    public boolean removeVehicle(Vehicle vehicle) {
        return rentalVehicles.remove(vehicle);
    }

    public ArrayList<Vehicle> vehiclesInStock() {
        return new ArrayList<>(rentalVehicles);
    }

    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency("Enterprise", "Brooklyn", "NY");

        Vehicle v1 = new Vehicle("Toyota", "Camry", 2022, 50);
        Vehicle v2 = new Vehicle("Honda", "Civic", 2023, 75);
        Vehicle v3 = new Vehicle("Ford", "Mustang", 2021, 85);

        agency.addVehicle(v1);
        agency.addVehicle(v2);
        agency.addVehicle(v3);

        System.out.println("Current Inventory:");
        for (Vehicle v : agency.vehiclesInStock()) {
            System.out.println(v);
        }

        Vehicle rented = agency.rentVehicle(1);
        System.out.println("\nRented: " + rented);

        System.out.println("\nRemaining Inventory:");
        for (Vehicle v : agency.vehiclesInStock()) {
            System.out.println(v);
        }

        double cost = agency.returnVehicle(rented, 5);
        System.out.println("\nReturned Vehicle ID: " + rented.getId() + ", Total Cost: $" + cost);
    }
}

package problem2;

public class RentalAgency {
    private static final int CAPACITY = 10;
    private String name;
    private String city;
    private String state;
    private RentalCar[] rentalCars = new RentalCar[CAPACITY];
    private int[] rented = new int[CAPACITY];

    
    public RentalAgency(String name, String city, String state) {
    	this.name = name;
        this.city = city;
        this.state = state;
        for (int i = 0; i < CAPACITY; i++) rented[i] = -1;
    }
    
    public String getName() { return name; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public RentalCar[] getCars() { return rentalCars; }

    public int totalRentalCars() {
        int count = 0;
        for (RentalCar car : rentalCars) {
            if (car != null) count++;
        }
        return count;
    }
    
    public RentalCar rentCar(int id) {
        for (int i = 0; i < CAPACITY; i++) {
            if (rentalCars[i] != null && rentalCars[i].getId() == id && rented[i] == -1) {
                rented[i] = id;
                return rentalCars[i];
            }
        }
        return null;
    }
    
    public double returnCar(int id, int days) {
        for (int i = 0; i < CAPACITY; i++) {
            if (rentalCars[i] != null && rentalCars[i].getId() == id && rented[i] != -1) {
                rented[i] = -1;
                return rentalCars[i].getDailyCost() * days;
            }
        }
        return -1;
    }
    
    public RentalCar[] carsInStock() {
        int count = totalRentalCars();
        RentalCar[] availableCars = new RentalCar[count];
        int index = 0;
        for (int i = 0; i < CAPACITY; i++) {
            if (rentalCars[i] != null && rented[i] == -1) {
                availableCars[index++] = rentalCars[i];
            }
        }
        return availableCars;
    }
    
    public boolean addCar(RentalCar car) {
        for (int i = 0; i < CAPACITY; i++) {
            if (rentalCars[i] == null) {
                rentalCars[i] = car;
                return true;
            }
        }
        return false;
    }

    public boolean removeCar(int id) {
        for (int i = 0; i < CAPACITY; i++) {
            if (rentalCars[i] != null && rentalCars[i].getId() == id && rented[i] == -1) {
                rentalCars[i] = null;
                return true;
            }
        }
        return false;
    }

    
    public static void main(String[] args) {
        RentalAgency enterprise = new RentalAgency("Enterprise", "Brooklyn, New York", "NY");
        
        RentalCar car1 = new RentalCar("Toyota", "Camry", 2022, 50);
        RentalCar car2 = new RentalCar("Honda", "Civic", 2023, 75);
        RentalCar car3 = new RentalCar("Ford", "Mustang", 2021, 85);
        
        enterprise.addCar(car1);
        enterprise.addCar(car2);
        enterprise.addCar(car3);
        
        System.out.println("Current Inventory:");
        for (RentalCar car : enterprise.carsInStock()) {
            System.out.println(car);
        }
        
        RentalCar rentedCar = enterprise.rentCar(3);
        if (rentedCar != null) {
            System.out.println("\nRented Car: " + rentedCar);
        }
        
        System.out.println("\nRemaining Inventory:");
        for (RentalCar car : enterprise.carsInStock()) {
            System.out.println(car);
        }
        
        double cost = enterprise.returnCar(3, 5);
        System.out.println("\nReturned Car ID: " + rentedCar.getId() + ", Total Cost: $" + cost);
    }
}

package problem2;

public class RentalCar {
	private static int nextId = 1;
    private int id;
    private String make;
    private String model;
    private int year;
    private double dailyCost;
    
    public RentalCar(String make, String model, int year, double dailyCost) {
        this.id = nextId++;
        this.make = make;
        this.model = model;
        this.year = year;
        this.dailyCost = dailyCost;
    }
    
    public int getId() { return id; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getDailyCost() { return dailyCost; }
    
    public void setDailyCost(double dailyCost) {
        this.dailyCost = dailyCost;
    }
    
    public String toString() {
        return "RentalCar{id=" + id + ", make='" + make + "', model='" + model + "', year=" + year + ", dailyCost=" + dailyCost + "}";
    }
}

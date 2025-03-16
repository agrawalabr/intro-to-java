package partI;

import java.util.Objects;

public class Vehicle {
	private int id;
	private static int nextId;
	private String make;
	private String model;
	private int year;
	private double rentalRate;
	
	public Vehicle() {
		id = nextId++;
	}
	
	public Vehicle(String make, String model, int year, double rentalRate) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.rentalRate = rentalRate;
		id = nextId++;
	}
	
	public void setMake(String value) {
		this.make = value;
	}
	
	public void setModel(String value) {
		this.model = value;
	}
	
	public void setRentalRate(double value) {
		this.rentalRate = value;
	}
	
	public void setYear(int value) {
		this.year = value;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getMake() {
		return this.make;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public double getRentalRate() {
		return this.rentalRate;
	}
	
	public int getYear() {
		return this.year;
	}

	public String toString() {
		return "Vehicle [id=" + id + ", make=" + make + ", model=" + model + ", year=" + year + ", rentalRate="
				+ rentalRate + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return id == other.id && Objects.equals(make, other.make) && Objects.equals(model, other.model)
				&& Double.doubleToLongBits(rentalRate) == Double.doubleToLongBits(other.rentalRate)
				&& year == other.year;
	}	
	
	
} 
 

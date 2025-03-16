package partI;

public class Truck extends Vehicle {
	
	private double cargoCapacity;
	
	public Truck() {
		super();
	}
	
	public Truck(String make, String model, int year, double rentalRate, double value) {
		super(make, model, year, rentalRate);
		this.cargoCapacity = value;
	}
	
	public void setCargoCapacity(double value) {
		this.cargoCapacity = value;
	}
	
	public double getCargoCapacity() {
		return this.cargoCapacity;
	}
	
	public String toString() {
		return "Truck [cargoCapacity=" + getCargoCapacity() + ", id=" + getId() + ", year=" + getYear() + ", model" + getModel() + ", class" + getClass() + "]";
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Truck other = (Truck) obj;
		return other.getMake().equals(getMake()) 
				&& other.getClass().equals(getClass())
						&& other.getModel().equals(getModel()) 
						&& Double.doubleToLongBits(other.getRentalRate()) == Double.doubleToLongBits(getRentalRate())
						&& cargoCapacity == other.getCargoCapacity();
	}
	
}
package partI;

public class DeliveryTruck extends Truck {
	
	private double height;
	
	public DeliveryTruck() {
		super();
	}
	
	public DeliveryTruck(String make, String model, int year, double rentalRate, double cargoCapacity, double height) {
		super(make, model, year, rentalRate, cargoCapacity);
		this.height = height;
	}
	
	public void setHeight(double value) {
		this.height = value;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public String toString() {
		return "Pickup Truck [cargoCapacity=" + getCargoCapacity() + ", id=" + getId() + ", year=" + getYear() + ", model" + getModel() + ", class" + getClass() + 
				", height=" + getHeight() +  "]";
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		DeliveryTruck other = (DeliveryTruck) obj;
		return other.getMake().equals(getMake()) 
				&& other.getClass().equals(getClass())
						&& other.getModel().equals(getModel()) 
						&& Double.doubleToLongBits(other.getRentalRate()) == Double.doubleToLongBits(getRentalRate())
						&& Double.doubleToLongBits(other.getCargoCapacity()) == Double.doubleToLongBits(getCargoCapacity())
						&& height == other.height;
	}
	
}
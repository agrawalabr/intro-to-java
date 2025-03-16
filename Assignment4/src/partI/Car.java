package partI;

public class Car extends Vehicle {
	
	private int numSeats;
	
	
	
	public Car() {
		super();
	}

	public Car(String make, String model, int year, double rentalRate, int numSeats) {
		super(make, model, year, rentalRate);
		this.numSeats = numSeats;
	}

	public void setNumSeats(int value) {
		this.numSeats = value;
	}
	
	public int getNumSeats() {
		return this.numSeats;
	}

	public String toString() {
		return "Car [numSeats=" + numSeats + ", id=" + getId() + ", year=" + getYear()  + ", model" + getModel()  + ", class" + getClass() + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return other.getMake().equals(getMake()) 
				&& other.getClass().equals(getClass())
						&& other.getModel().equals(getModel()) 
						&& Double.doubleToLongBits(other.getRentalRate()) == Double.doubleToLongBits(getRentalRate())
						&& numSeats == other.numSeats;
	}
	
	
	
}
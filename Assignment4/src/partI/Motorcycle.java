package partI;

public class Motorcycle extends Vehicle {
	
	private boolean hasSidecar;
	
	public Motorcycle() {
		super();
	}
	
	public Motorcycle(String make, String model, int year, double rentalRate, boolean value) {
		super(make, model, year, rentalRate);
		this.hasSidecar = value;
	}
	
	public void setHasSidecar(boolean value) {
		this.hasSidecar = value;
	}
	
	public boolean getHasSidecar() {
		return this.hasSidecar;
	}
	
	public String toString() {
		return "Motorcycle [hasSideCar=" + getHasSidecar() + ", id=" + getId() + ", year=" + getYear() + ", model" + getModel() + ", class" + getClass() + "]";
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Motorcycle other = (Motorcycle) obj;
		return other.getMake().equals(getMake()) 
				&& other.getClass().equals(getClass())
						&& other.getModel().equals(getModel()) 
						&& Double.doubleToLongBits(other.getRentalRate()) == Double.doubleToLongBits(getRentalRate())
						&& hasSidecar == other.getHasSidecar();
	}
}
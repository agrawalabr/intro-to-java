package partI;

public class PickupTruck extends Truck {
	
	private double bedlength;
	private boolean crewCab;
	
	
	public PickupTruck() {
		super();
	}
	
	public PickupTruck(String make, String model, int year, double rentalRate, double cargoCapacity, double bedlength, boolean crewCab) {
		super(make, model, year, rentalRate, cargoCapacity);
		this.bedlength = bedlength;
		this.crewCab = crewCab;
	}
	
	public void setBedlength(double value) {
		this.bedlength = value;
	}
	
	public double getBedlength() {
		return this.bedlength;
	}
	
	public void setCrewCab(boolean value) {
		this.crewCab = value;
	}
	
	public boolean getCrewCab() {
		return this.crewCab;
	}
	
	public String toString() {
		return "Pickup Truck [cargoCapacity=" + getCargoCapacity() + ", id=" + getId() + ", year=" + getYear() + ", model" + getModel() + ", class" + getClass() + 
				", bedlength=" + getBedlength() + ", hasCrewCab=" + getCrewCab() +  "]";
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		PickupTruck other = (PickupTruck) obj;
		return other.getMake().equals(getMake()) 
				&& other.getClass().equals(getClass())
						&& other.getModel().equals(getModel()) 
						&& Double.doubleToLongBits(other.getRentalRate()) == Double.doubleToLongBits(getRentalRate())
						&& Double.doubleToLongBits(other.getCargoCapacity()) == Double.doubleToLongBits(getCargoCapacity())
						&& bedlength == other.bedlength
						&& crewCab == other.crewCab;
	}
	
}
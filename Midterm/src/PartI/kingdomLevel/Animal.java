package PartI.kingdomLevel;

import PartI.Lifeform;

public class Animal extends Lifeform {
	public Boolean isMobile;
	public String dietType;
	
	public Animal(String name, String scientificName, Integer lifespan, Boolean isMobile, String dietType) {
		super(name, scientificName, lifespan);
		this.isMobile = isMobile;
        this.dietType = dietType;
	}

	@Override
	public String describe() {
		return super.getDetails() +
				"\nMobility: " + isMobile +
				"\nDiet: " + dietType;
	}
}
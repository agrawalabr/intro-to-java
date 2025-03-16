package PartI.phylumLevel;

import PartI.kingdomLevel.Animal;

public class Arthropod extends Animal {
	public Boolean exoskeleton;
	public Integer legCount;
	
	public Arthropod(String name, String scientificName, Integer lifespan, Boolean isMobile, String dietType, Boolean exoskeleton, Integer legCount) {
		super(name, scientificName, lifespan, isMobile, dietType);
		this.exoskeleton = exoskeleton;
		this.legCount = legCount;
	}
	
	@Override
	public String describe() {
		return super.describe() +
				"\nExoskeleton: " + exoskeleton +
				"\nLeg Count: " + legCount;
	}
}
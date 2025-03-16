package PartI.phylumLevel;

import PartI.kingdomLevel.Animal;

public class Chordate extends Animal {
	public Boolean vertebrate;
	public Integer nervousSystemComplexity;

	public Chordate(String name, String scientificName, Integer lifespan, Boolean isMobile, String dietType, Boolean vertebrate, Integer nervousSystemComplexity) {
		super(name, scientificName, lifespan, isMobile, dietType);
		this.vertebrate = vertebrate;
		this.nervousSystemComplexity = nervousSystemComplexity;
	}
	
	@Override
	public String describe() {
		return super.describe() +
				"\nVertebrate: " + vertebrate +
				"\nNervous System Complexity: " + nervousSystemComplexity;
	}
}
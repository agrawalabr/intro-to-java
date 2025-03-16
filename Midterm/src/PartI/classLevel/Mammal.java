package PartI.classLevel;

import PartI.phylumLevel.Chordate;

public class Mammal extends Chordate {
	public Boolean warmBlooded;
	public Integer gestationPeriod;

	public Mammal(String name, String scientificName, Integer lifespan, Boolean isMobile, String dietType, Boolean vertebrate, Integer nervousSystemComplexity, Boolean warmBlooded, Integer gestationPeriod) {
		super(name, scientificName, lifespan, isMobile, dietType, vertebrate, nervousSystemComplexity);
		this.warmBlooded = warmBlooded;
		this.gestationPeriod = gestationPeriod;
	}
	
	@Override
	public String describe() {
		return super.describe() +
				"\nWarm Blooded: " + warmBlooded +
				"\nGestation Period: " + gestationPeriod;
	}
}

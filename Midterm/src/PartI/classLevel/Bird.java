package PartI.classLevel;

import PartI.phylumLevel.Chordate;

public class Bird extends Chordate {
	public Double wingSpan;
	public Boolean canFly;

	public Bird(String name, String scientificName, Integer lifespan, Boolean isMobile, String dietType, Boolean vertebrate, Integer nervousSystemComplexity, Double wingSpan, Boolean canFly) {
		super(name, scientificName, lifespan, isMobile, dietType, vertebrate, nervousSystemComplexity);
		this.wingSpan = wingSpan;
		this.canFly = canFly;
	}
	
	@Override
	public String describe() {
		return super.describe() +
				"\nWing Span: " + wingSpan +
				"\nFly: " + canFly;
	}
}
package PartI.classLevel;

import PartI.phylumLevel.Arthropod;

public class Insect extends Arthropod {
	public Integer wingCount;
	public String metamorphosisStage;

	public Insect(String name, String scientificName, Integer lifespan, Boolean isMobile, String dietType, Boolean exoskeleton, Integer legCount, Integer wingCount, String metamorphosisStage) {
		super(name, scientificName, lifespan, isMobile, dietType, exoskeleton, legCount);
		this.wingCount = wingCount;
		this.metamorphosisStage = metamorphosisStage;
	}
	
	@Override
	public String describe() {
		return super.describe() +
				"\nWing Count: " + wingCount +
				"\nMetamorphosis Stage: " + metamorphosisStage;
	}
}

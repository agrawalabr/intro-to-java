package PartI.genusLevel;

import PartI.familyLevel.Canidae;

public class Canis extends Canidae {
    protected Double howlLoudness;
    protected Double endurance;
    
    public Canis(String name, String scientificName, Integer lifespan, Boolean isMobile, String dietType, Boolean vertebrate, Integer nervousSystemComplexity, Boolean warmBlooded, Integer gestationPeriod, String huntingStrategy, Double biteForce, Double climbingAbility, Double roarVolume, Double howlLoudness, Double endurance) {
        super(name, scientificName, lifespan, isMobile, dietType, vertebrate, nervousSystemComplexity, warmBlooded, gestationPeriod, huntingStrategy, biteForce, climbingAbility, roarVolume);
        this.howlLoudness = howlLoudness;
        this.endurance = endurance;
    }
    
    @Override
    public String describe() {
        return super.describe() +
			"\nHowl Loudness: " + howlLoudness +
			"\nEndurance: " + endurance;
    }
}
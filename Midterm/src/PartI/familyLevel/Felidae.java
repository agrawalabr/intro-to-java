package PartI.familyLevel;

import PartI.orderLevel.Carnivore;

public class Felidae extends Carnivore {
    protected Double climbingAbility;
    protected Double roarVolume;
    
    public Felidae(String name, String scientificName, Integer lifespan, Boolean isMobile, String dietType, Boolean vertebrate, Integer nervousSystemComplexity, Boolean warmBlooded, Integer gestationPeriod, String huntingStrategy, Double biteForce, Double climbingAbility, Double roarVolume) {
        super(name, scientificName, lifespan, isMobile, dietType, vertebrate, nervousSystemComplexity, warmBlooded, gestationPeriod, huntingStrategy, biteForce);
        this.climbingAbility = climbingAbility;
        this.roarVolume = roarVolume;
    }
    
    @Override
    public String describe() {
        return super.describe() +
			"\nClimbing Ability: " + climbingAbility +
			"\nVision Range: " + roarVolume;
    }
}
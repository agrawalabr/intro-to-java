package PartI.genusLevel;

import PartI.familyLevel.Felidae;

public class Panthera extends Felidae {
    protected Double territorySize;
    protected Double maneSize;
    
    public Panthera(String name, String scientificName, Integer lifespan, Boolean isMobile, String dietType, Boolean vertebrate, Integer nervousSystemComplexity, Boolean warmBlooded, Integer gestationPeriod, String huntingStrategy, Double biteForce, Double climbingAbility, Double roarVolume, Double territorySize, Double maneSize) {
        super(name, scientificName, lifespan, isMobile, dietType, vertebrate, nervousSystemComplexity, warmBlooded, gestationPeriod, huntingStrategy, biteForce, climbingAbility, roarVolume);
        this.territorySize = territorySize;
        this.maneSize = maneSize;
    }
    
    @Override
    public String describe() {
        return super.describe() +
			"\nTerritory Size: " + territorySize +
			"\nMane Size: " + maneSize;
    }
}
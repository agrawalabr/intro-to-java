package PartI.speciesLevel;

import PartI.genusLevel.Panthera;

public class Lion extends Panthera {
    protected Integer prideSize;
    protected String maneColor;
    
    public Lion(String name, String scientificName, Integer lifespan, Boolean isMobile, String dietType, Boolean vertebrate, Integer nervousSystemComplexity, Boolean warmBlooded, Integer gestationPeriod, String huntingStrategy, Double biteForce, Double climbingAbility, Double roarVolume, Double territorySize, Double maneSize, Integer prideSize, String maneColor) {
        super(name, scientificName, lifespan, isMobile, dietType, vertebrate, nervousSystemComplexity, warmBlooded, gestationPeriod, huntingStrategy, biteForce, climbingAbility, roarVolume, territorySize, maneSize);
        this.prideSize = prideSize;
        this.maneColor = maneColor;
    }
    
    @Override
    public String describe() {
        return super.describe() +
			"\nPride Size: " + prideSize +
			"\nMane Color: " + maneColor;
    }
}
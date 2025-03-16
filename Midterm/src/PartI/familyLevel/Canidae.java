package PartI.familyLevel;

import PartI.orderLevel.Carnivore;

public class Canidae extends Carnivore {
    protected Double packInstinct;
    protected Double olfactorySensitivity;
    
    public Canidae(String name, String scientificName, Integer lifespan, Boolean isMobile, String dietType, Boolean vertebrate, Integer nervousSystemComplexity, Boolean warmBlooded, Integer gestationPeriod, String huntingStrategy, Double biteForce, Double packInstinct, Double olfactorySensitivity) {
        super(name, scientificName, lifespan, isMobile, dietType, vertebrate, nervousSystemComplexity, warmBlooded, gestationPeriod, huntingStrategy, biteForce);
        this.packInstinct = packInstinct;
        this.olfactorySensitivity = olfactorySensitivity;
    }
    
    @Override
    public String describe() {
        return super.describe() +
			"\nPack Instinct: " + packInstinct +
			"\nOlfactory Sensitivity: " + olfactorySensitivity;
    }
}
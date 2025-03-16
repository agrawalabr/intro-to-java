package PartI.orderLevel;

import PartI.classLevel.Mammal;

public class Carnivore extends Mammal {
    protected String huntingStrategy;
    protected Double biteForce;
    
    public Carnivore(String name, String scientificName, Integer lifespan, Boolean isMobile, String dietType, Boolean vertebrate, Integer nervousSystemComplexity, Boolean warmBlooded, Integer gestationPeriod, String huntingStrategy, Double biteForce) {
        super(name, scientificName, lifespan, isMobile, dietType, vertebrate, nervousSystemComplexity, warmBlooded, gestationPeriod);
        this.huntingStrategy = huntingStrategy;
        this.biteForce = biteForce;
    }
    
    @Override
    public String describe() {
        return super.describe() +
			"\nHunting Strategy: " + huntingStrategy +
			"\nBite Force: " + biteForce;
    }
}
package PartI.orderLevel;

import PartI.classLevel.Mammal;

public class Herbivore extends Mammal {
    protected Integer ruminationTime;
    protected Boolean herdBehavior;
    
    public Herbivore(String name, String scientificName, Integer lifespan, Boolean isMobile, String dietType, Boolean vertebrate, Integer nervousSystemComplexity, Boolean warmBlooded, Integer gestationPeriod, Integer ruminationTime, Boolean herdBehavior) {
        super(name, scientificName, lifespan, isMobile, dietType, vertebrate, nervousSystemComplexity, warmBlooded, gestationPeriod);
        this.ruminationTime = ruminationTime;
        this.herdBehavior = herdBehavior;
    }
    
    @Override
    public String describe() {
        return super.describe() +
			"\nRumination Time: " + ruminationTime +
			"\nHerd Behavior: " + herdBehavior;
    }
}

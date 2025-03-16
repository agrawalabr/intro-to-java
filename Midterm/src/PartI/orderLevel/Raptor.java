package PartI.orderLevel;

import PartI.classLevel.Bird;

public class Raptor extends Bird {
    protected Double talonStrength;
    protected Double visionRange;
    
    public Raptor(String name, String scientificName, Integer lifespan, Boolean isMobile, String dietType, Boolean vertebrate, Integer nervousSystemComplexity, Double wingSpan, Boolean canFly, Double talonStrength, Double visionRange) {
        super(name, scientificName, lifespan, isMobile, dietType, vertebrate, nervousSystemComplexity, wingSpan, canFly);
        this.talonStrength = talonStrength;
        this.visionRange = visionRange;
    }
    
    @Override
    public String describe() {
        return super.describe() +
			"\nTalon Strength: " + talonStrength +
			"\nVision Range: " + visionRange;
    }
}
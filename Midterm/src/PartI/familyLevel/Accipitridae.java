package PartI.familyLevel;

import PartI.orderLevel.Raptor;

public class Accipitridae extends Raptor {
    protected Double predationSuccessRate;
    protected Double wingLoading;
    
    public Accipitridae(String name, String scientificName, Integer lifespan, Boolean isMobile, String dietType, Boolean vertebrate, Integer nervousSystemComplexity, Double wingSpan, Boolean canFly, Double talonStrength, Double visionRange, Double predationSuccessRate, Double wingLoading) {
        super(name, scientificName, lifespan, isMobile, dietType, vertebrate, nervousSystemComplexity, wingSpan, canFly, talonStrength, visionRange);
        this.predationSuccessRate = predationSuccessRate;
        this.wingLoading = wingLoading;
    }
    
    @Override
    public String describe() {
        return super.describe() +
			"\nPredation Success Rate: " + predationSuccessRate +
			"\nWing Loading: " + wingLoading;
    }
}
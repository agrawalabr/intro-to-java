package PartI.speciesLevel;

import PartI.genusLevel.Canis;

public class Wolf extends Canis {
    protected Double packLeadershipScore;
    protected Integer howlFrequency;
    
    public Wolf(String name, String scientificName, Integer lifespan, Boolean isMobile, String dietType, Boolean vertebrate, Integer nervousSystemComplexity, Boolean warmBlooded, Integer gestationPeriod, String huntingStrategy, Double biteForce, Double climbingAbility, Double roarVolume, Double howlLoudness, Double endurance, Double packLeadershipScore, Integer howlFrequency) {
        super(name, scientificName, lifespan, isMobile, dietType, vertebrate, nervousSystemComplexity, warmBlooded, gestationPeriod, huntingStrategy, biteForce, climbingAbility, roarVolume, howlLoudness, endurance);
        this.packLeadershipScore = packLeadershipScore;
        this.howlFrequency = howlFrequency;
    }
    
    @Override
    public String describe() {
        return super.describe() +
			"\nPack Leadership Score: " + packLeadershipScore +
			"\nHowl Frequency: " + howlFrequency;
    }
}
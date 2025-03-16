package PartI.orderLevel;

import PartI.classLevel.Bird;

public class Passerine extends Bird {
    protected Integer songComplexity;
    protected String beakType;
    
    public Passerine(String name, String scientificName, Integer lifespan, Boolean isMobile, String dietType, Boolean vertebrate, Integer nervousSystemComplexity, Double wingSpan, Boolean canFly, Integer songComplexity, String beakType) {
        super(name, scientificName, lifespan, isMobile, dietType, vertebrate, nervousSystemComplexity, wingSpan, canFly);
        this.songComplexity = songComplexity;
        this.beakType = beakType;
    }
    
    @Override
    public String describe() {
        return super.describe() +
			"\nSong Complexity: " + songComplexity +
			"\nBeak Type: " + beakType;
    }
}

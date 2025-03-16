package PartI.kingdomLevel;

import PartI.Lifeform;

public class Plant extends Lifeform {
	public Double photosynthesisEfficiency;
	public Double growthRate;
	
	public Plant(String name, String scientificName, Integer lifespan, Double photosynthesisEfficiency, Double growthRate) {
		super(name, scientificName, lifespan);
		this.photosynthesisEfficiency = photosynthesisEfficiency;
        this.growthRate = growthRate;
	}

	@Override
	public String describe() {
		return super.getDetails() +
				"\nPhotosynthesis Efficiency: " + photosynthesisEfficiency +
				"\nGrowth Rate: " + growthRate;
	}
}

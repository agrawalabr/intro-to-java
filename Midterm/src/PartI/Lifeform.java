package PartI;

public abstract class Lifeform {
	public String name;
	public String scientificName;
	public Integer lifespan;
	
	public Lifeform(String name, String scientificName, Integer lifespan) {
        this.name = name;
        this.scientificName = scientificName;
        this.lifespan = lifespan;
    }
	
	public abstract String describe();
	
	public String getDetails() {
		return  "Name: " + name + 
				"\nScientific Name: " + scientificName + 
				"\nLifespan: " + lifespan ;
	};
}
package PartI;

import PartI.classLevel.*;
import PartI.kingdomLevel.*;
import PartI.orderLevel.*;
import PartI.speciesLevel.*;
import java.util.*;

public class main {
	private static void printLifeforms(ArrayList<Lifeform> lifeforms) {
    for (Lifeform life : lifeforms) {
        System.out.println(life.name + " (" + life.lifespan + " years)");
		}
	}

	public static void main(String[] args) {
		Lion simba = new Lion("Simba", "Panthera leo", 15, true, "Carnivore", true, 9, true, 110, "Ambush", 650.0, 7.5, 114.0, 100.0, 4.5, 15, "Golden");
		Wolf ghost = new Wolf("Ghost", "Canis lupus", 13, true, "Carnivore", true, 8, true, 63, "Pack hunting", 400.0, 9.0, 10.0, 85.0, 9.5, 8.5, 12);
		Passerine robin = new Passerine("Robin", "Turdus migratorius", 6, true, "Omnivore", true, 6, 0.3, true, 7, "Short, pointed");
		Insect butterfly = new Insect("Monarch Butterfly", "Danaus plexippus", 1, true, "Herbivore", true, 6, 4, "Complete");
		Plant oak = new Plant("Oak Tree", "Quercus robur", 500, 0.8, 0.5);

		ArrayList<Lifeform> lifeforms = new ArrayList<>();
		lifeforms.add(simba); lifeforms.add(ghost); lifeforms.add(robin); lifeforms.add(butterfly); lifeforms.add(oak);

		System.out.println("\nDescriptions:");
		for (Lifeform life : lifeforms) {
			System.out.println("\n" + life.describe());
		}

		System.out.println("\nOriginal order:");
		printLifeforms(lifeforms);
		
		System.out.println("\nSorted by lifespan (ascending):");
		lifeforms.sort((life1, life2) -> Integer.compare(life1.lifespan, life2.lifespan));
		printLifeforms(lifeforms);
		
		System.out.println("\nSorted by name (alphabetically):");
		lifeforms.sort((life1, life2) -> life1.name.compareTo(life2.name));
		printLifeforms(lifeforms);
	}
}
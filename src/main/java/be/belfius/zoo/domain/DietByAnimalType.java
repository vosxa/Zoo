package be.belfius.zoo.domain;

import be.belfius.zoo.domain.enums.AnimalType;

public class DietByAnimalType {
	private AnimalType animalType;
	private String foodType;
	private int nbPortions;
	
	public DietByAnimalType(AnimalType animalType, String foodType, int nbPortions) {
		super();
		this.animalType = animalType;
		this.foodType = foodType;
		this.nbPortions = nbPortions;
	}

	@Override
	public String toString() {
		return animalType.getAnimalDescr() + "(" + foodType + " - " + nbPortions + " portions)";
	}


	public AnimalType getAnimalType() {
		return animalType;
	}


	public void setAnimalType(AnimalType animalType) {
		this.animalType = animalType;
	}


	public String getFoodType() {
		return foodType;
	}


	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}


	public int getNbPortions() {
		return nbPortions;
	}


	public void setNbPortions(int nbPortions) {
		this.nbPortions = nbPortions;
	}
	
	

}

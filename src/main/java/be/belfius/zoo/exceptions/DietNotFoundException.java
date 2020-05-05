package be.belfius.zoo.exceptions;

import be.belfius.zoo.domain.DietByAnimalType;
import be.belfius.zoo.domain.enums.AnimalType;

public class DietNotFoundException extends Exception {
	AnimalType animalType;

	public DietNotFoundException(AnimalType animalType) {
		super();
		this.animalType = animalType;
	}

	@Override
	public String getMessage() {
		return "Sorry, we don't have the Diet for a : " + animalType;
	}
	
	
	
	
}

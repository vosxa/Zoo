package be.belfius.zoo.domain.enums;

import be.belfius.zoo.exceptions.InvalidAnimalTypeException;

public enum AnimalType {
	BEAR("Bear"), LION("Lion"), TIGER("Tiger"), SNAKE("Snake");

	private String animalDescr;

	private AnimalType(String animalDescr) {
		this.animalDescr = animalDescr;
	}

	public String getAnimalDescr() {
		return animalDescr;
	}

	public static AnimalType findAnimalTypefromDescr(String animalDesc) throws InvalidAnimalTypeException {
		AnimalType myReturn=null;
		for (AnimalType animalType : AnimalType.values()) {
			if (animalType.getAnimalDescr().equals(animalDesc)) {
				myReturn = animalType;
			}
		}
		
		if (myReturn==null) { 
			throw new InvalidAnimalTypeException(animalDesc);
		}
		return myReturn;
	}

	public static String getValidAnimalTypes() {
		String myReturn = "";
		
		for (AnimalType animalType : AnimalType.values()) {
			myReturn = myReturn + animalType.getAnimalDescr() + " " ;
		}
		
		return myReturn;
	}
}

package be.belfius.zoo.services;

import java.util.List;

import be.belfius.zoo.domain.*;
import be.belfius.zoo.domain.enums.AnimalType;
import be.belfius.zoo.exceptions.InvalidAnimalTypeException;
import be.belfius.zoo.repository.AnimalRepository;

public class AnimalService {
	private AnimalRepository animalRepository = new AnimalRepository();

	private AnimalType enAnimalType = null;
	private String inAnimalName;

	public void createAnimal(String inAnimalType, String inAnimalName) throws InvalidAnimalTypeException {
		switch (inAnimalType) {

		case "Bear":
			Bear bear = new Bear(AnimalType.BEAR, inAnimalName);
			animalRepository.addAnimal(bear);
			break;

		case "Lion":
			Lion lion = new Lion(AnimalType.LION, inAnimalName);
			animalRepository.addAnimal(lion);
			break;

		case "Tiger":
			Tiger tiger = new Tiger(AnimalType.TIGER, inAnimalName);
			animalRepository.addAnimal(tiger);
			break;

		default:
			throw new InvalidAnimalTypeException(inAnimalType);
		}
	}

	public boolean deleteAnimal(String inAnimalName) {
		Animal delAnimal = new Lion(enAnimalType, inAnimalName);

		delAnimal.setName(inAnimalName);

		return animalRepository.deleteAnimal(delAnimal);
	}

	public List<Animal> findAnimalsPerType(String inAnimalType) throws InvalidAnimalTypeException {
		Animal findAnimal = new Lion(enAnimalType, inAnimalName);

		for (AnimalType animalType : AnimalType.values()) {
			if (animalType.getAnimalDescr().equals(inAnimalType)) {
				findAnimal.setAnimalType(animalType);
			}
		}
		if (findAnimal.getAnimalType()==null) {
			throw new InvalidAnimalTypeException(inAnimalType);
		}	
		return animalRepository.findAnimalsByType(findAnimal);
	}
	
	public List<Animal> getAllAnimals() {
		return animalRepository.getAllAnimals();
	}

	public Animal getOneAnimal(Bear bear) {
		return animalRepository.getOneAnimal(bear);
	}

	/* public AnimalType findAnimalType(String inAnimalType) throws InvalidAnimalTypeException {
		Animal findAnimal = new Lion(enAnimalType, inAnimalName);

		for (AnimalType animalType : AnimalType.values()) {
			if (animalType.getAnimalDescr().equals(inAnimalType)) {
				findAnimal.setAnimalType(animalType);
			}
		}
		if (findAnimal.getAnimalType()==null) {
			throw new InvalidAnimalTypeException(inAnimalType);
		}	
		return findAnimal.getAnimalType();
	} */
	
}

package be.belfius.zoo.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import be.belfius.zoo.domain.Animal;
import be.belfius.zoo.domain.Bear;
import be.belfius.zoo.domain.Lion;
import be.belfius.zoo.domain.enums.AnimalType;

public class AnimalRepository {
	private List<Animal> animals = new ArrayList<>();

	public AnimalRepository() {
		Bear bear = new Bear(AnimalType.BEAR, "Baloe");
		animals.add(bear);

		Lion lion = new Lion(AnimalType.LION, "King");
		animals.add(lion);

	}

	public List<Animal> getAllAnimals() {
		sortByAnimalNames();
		return animals;
	}

	public void sortByAnimalNames() {
		Collections.sort(animals);
	}

	public Animal getOneAnimal(Animal getAnimal) {
		Animal foundAnimal = new Lion(null, null);
		for (Animal oneAnimal : animals) {
			if (oneAnimal.getName().equals(getAnimal.getName())) {
				foundAnimal = oneAnimal;
				continue;
			}
		}
		
		return foundAnimal;
	}

	public void addAnimal(Animal newAnimal) { // CREATE
		Animal local = null;
		local = getOneAnimal(newAnimal);
		if (local.getName() != null) {
			System.out.println(local.getName() + " lives already in our zoo. Please try again and enter another name.");
		} else {
			animals.add(newAnimal);
		}
	}

	public void updateAnimal(Animal updAnimal) { // UPDATE
		animals.set(animals.indexOf(updAnimal), updAnimal);
	}

	public boolean deleteAnimal(Animal delAnimal) {
		Animal local = null;
		local = getOneAnimal(delAnimal);
		if (local.getName() != null) {
			animals.remove(local);
			return true;

		} else {
			return false;
		}
	}

	public List<Animal> findAnimalsByType(Animal getAnimal) {
		List<Animal> foundAnimalsList = new ArrayList<>();

		for (Animal oneAnimal : animals) {
			if (oneAnimal.getAnimalType().equals(getAnimal.getAnimalType())) {
				foundAnimalsList.add(oneAnimal);
			}
		}
		return foundAnimalsList;
	}
}

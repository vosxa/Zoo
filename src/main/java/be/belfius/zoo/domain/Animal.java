package be.belfius.zoo.domain;

import be.belfius.zoo.domain.enums.AnimalType;

public abstract class Animal implements Comparable<Animal> {

	private AnimalType animalType;
	private String name;

	public Animal(AnimalType animalType, String name) {
		super();
		this.animalType = animalType;
		this.name = name;
	}

	@Override
	public String toString() {
		return animalType + " " + name ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AnimalType getAnimalType() {
		return animalType;
	}

	public void setAnimalType(AnimalType animalType) {
		this.animalType = animalType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((animalType == null) ? 0 : animalType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (animalType != other.animalType)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Animal o) {
		return this.getName().compareTo(o.getName());
	}
	
	

}

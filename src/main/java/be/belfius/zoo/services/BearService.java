package be.belfius.zoo.services;

import be.belfius.zoo.domain.Animal;
import be.belfius.zoo.domain.Bear;
import be.belfius.zoo.repository.AnimalRepository;
import be.belfius.zoo.repository.BearRepositoryJPA;

import java.util.List;

public class BearService {
	private AnimalRepository animalRepository = new AnimalRepository();
	private static BearRepositoryJPA bearRepositoryJPA = new BearRepositoryJPA();
	
//	public List<Animal> getAllBear(){
//		return animalRepository.getAllAnimals("","");
//	}

	public static void save(Bear bear){
		bearRepositoryJPA.save(bear);
	}

}

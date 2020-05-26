package be.belfius.zoo;

import be.belfius.zoo.services.AnimalService;
import be.belfius.zoo.services.BearService;
import be.belfius.zoo.domain.Bear;
import be.belfius.zoo.services.FoodService;

public class ZooApplication {
	
	public static AnimalService animalService;
	public static FoodService foodService;

	public static void main(String[] args) {
		animalService = new AnimalService();
		foodService = new FoodService();

		
		
		System.out.println("WELCOME TO OUR ZOO. These are our friends : " + animalService.getAllAnimals());

//		new Menu().loopMenu(animalService, foodService);
        Bear bear = new Bear();
        bear.setName("jimbo");
        BearService.save(bear);

		System.out.println(animalService.getAllAnimals() + " SAY GOODBYE");
	}
}

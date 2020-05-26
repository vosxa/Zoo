package be.belfius.zoo.services;

import java.util.List;

import be.belfius.zoo.domain.Animal;
import be.belfius.zoo.domain.Bear;
import be.belfius.zoo.domain.DietByAnimalType;
import be.belfius.zoo.domain.Food;
import be.belfius.zoo.domain.enums.AnimalType;
import be.belfius.zoo.exceptions.DietNotFoundException;
import be.belfius.zoo.exceptions.FoodisEmptyException;
import be.belfius.zoo.exceptions.InvalidAnimalException;
import be.belfius.zoo.exceptions.InvalidAnimalTypeException;
import be.belfius.zoo.exceptions.InvalidFoodException;
import be.belfius.zoo.repository.FoodRepository;

public class FoodService {
 
	private FoodRepository foodRepository = new FoodRepository();

	public List<Food> getAllFood() {
		return foodRepository.getAllFood();
	}
	
	public List<DietByAnimalType> getAllDiets() {
		return foodRepository.getAllDiets();
	} 

	public void feedOneAnimal(String mAnimalName, AnimalService animalService) throws InvalidAnimalException, DietNotFoundException, FoodisEmptyException  {
		boolean oneDietLineFound = false;
		
//		Animal hungryAnimal =
//		(Animal) animalService.getOneAnimal(new Bear(null,mAnimalName));

//		if (hungryAnimal.getName() == null) {throw new InvalidAnimalException(mAnimalName) ;}
	
		//  backup nemen van diet
		List<Food> foodBU=foodRepository.backup();
		
//		for (DietByAnimalType oneDietLine : getDiet(hungryAnimal)) {
//			oneDietLineFound=true;
//			try {
//				foodRepository.takeFood(oneDietLine);
//			} catch (FoodisEmptyException e) {
//				foodRepository.restoreBU(foodBU);
//				throw new FoodisEmptyException();
//			}		
//		}	
		
/*		if (!oneDietLineFound)  {
			throw new DietNotFoundException(hungryAnimal.getAnimalType());
			}
*/		}
	
	private List<DietByAnimalType> getDiet(Animal hungryAnimal) {
		List<DietByAnimalType> dietHungryAnimal=foodRepository.getDiet(hungryAnimal);
		return dietHungryAnimal;
	}

	public boolean updateFoodStock(Food inFood) {
		return foodRepository.updateFoodStock(inFood);
	}

	public void addFood(String name, String calories, String portions, String type) {
		Food newFood=new Food(name, Integer.parseInt(calories), Integer.parseInt(portions), type );
		foodRepository.addFood(newFood);
		
	}

	public void addDiet(String mAnimalType, String mFoodName, int mAmount) throws InvalidAnimalTypeException, InvalidFoodException {
		DietByAnimalType newDiet;
		try {
			newDiet = new DietByAnimalType(AnimalType.findAnimalTypefromDescr(mAnimalType), mFoodName, mAmount);
			Food addFood=new Food(mFoodName,0,0,"");
			if (foodRepository.findFoodInStock(addFood) == true) {
				foodRepository.addDietByAnimalType(newDiet);
			}
			else { throw new InvalidFoodException();}
		} catch (InvalidAnimalTypeException e) {
			// TODO Auto-generated catch block
			throw new InvalidAnimalTypeException(mAnimalType);
		} 
		
	}
}

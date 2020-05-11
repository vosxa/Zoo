package be.belfius.zoo.repository;

import java.util.ArrayList;
import java.util.List;

import be.belfius.zoo.domain.Animal;
import be.belfius.zoo.domain.DietByAnimalType;
import be.belfius.zoo.domain.Food;
import be.belfius.zoo.domain.MeatFood;
import be.belfius.zoo.domain.VegFood;
import be.belfius.zoo.domain.enums.AnimalType;
import be.belfius.zoo.exceptions.FoodisEmptyException;

public class FoodRepository {

	private List<Food> food = new ArrayList<>();
	private List<DietByAnimalType> diet = new ArrayList<>();

	public FoodRepository() {

		// Fill FoodRepository
		VegFood lettuce = new VegFood("Lettuce", 1, 10);
		food.add(lettuce);

		VegFood grass = new VegFood("Grass", 2, 20);
		food.add(grass);

		MeatFood steak = new MeatFood("Steak", 6, 60);
		food.add(steak);

		MeatFood mouse = new MeatFood("Mouse", 7, 70);
		food.add(mouse);

		// Fill DietByAnimal
		DietByAnimalType crLine = new DietByAnimalType(AnimalType.BEAR, "Lettuce", 3);
		diet.add(crLine);

		crLine = new DietByAnimalType(AnimalType.BEAR, "Grass", 5);
		diet.add(crLine);

		crLine = new DietByAnimalType(AnimalType.LION, "Steak", 10);
		diet.add(crLine);

		crLine = new DietByAnimalType(AnimalType.TIGER, "Steak", 3);
		diet.add(crLine);

		crLine = new DietByAnimalType(AnimalType.TIGER, "Mouse", 10);
		diet.add(crLine);

	}

	public List<Food> getAllFood() {
		return food;
	}

	public List<DietByAnimalType> getAllDiets() {
		return diet;
	}

	public boolean updateFoodStock(Food updFood) {
		boolean found = false;
		for (Food foundFood : getAllFood()) {
			if (foundFood.getName().equals(updFood.getName())) {
				foundFood.setPortions(updFood.getPortions());
				found = true;
			}
		}

		if (found) {
			return true;
		} else {
			return false;
		}
	}

	public void reduceFoodStock(Food updFood, int portions) throws FoodisEmptyException {
		for (Food foundFood : getAllFood()) {
			if (foundFood.getName().equals(updFood.getName())) {
				if (foundFood.getPortions() >= portions) {
					foundFood.setPortions(foundFood.getPortions() - portions);
				} else {
					throw new FoodisEmptyException();
				}
			}
		}
	}

	public List<DietByAnimalType> getDiet(Animal hungryAnimal) {
		List<DietByAnimalType> foundDiet = new ArrayList<>();
		for (DietByAnimalType oneDiet : diet) {
/*			if (oneDiet.getAnimalType() == hungryAnimal.getAnimalType()) {
				foundDiet.add(oneDiet);
			}
*/		}
		return foundDiet;
	}

	public void takeFood(DietByAnimalType oneDietLine) throws FoodisEmptyException {
		Food updFood = new Food("", 0, 0, "");
		updFood.setName(oneDietLine.getFoodType());
		int portions = oneDietLine.getNbPortions();
		try {
			reduceFoodStock(updFood, portions);
		} catch (FoodisEmptyException e) {

			throw new FoodisEmptyException();
		}
	}

	public List<Food> backup() {
		List<Food> foodBU = new ArrayList<>();
		for (Food origFood : food) {
			foodBU.add(new Food(origFood));
		}
		return foodBU;
	}

	public void restoreBU(List<Food> foodBU) {
		this.food = foodBU;
	}

	public void addFood(Food newFood) {
		food.add(newFood);
	}

	public void addDietByAnimalType(DietByAnimalType newDiet) {
		diet.add(newDiet);
		
	}

	public boolean findFoodInStock(Food searchFood) {	
		boolean found = false;
		for (Food foundFood : getAllFood()) {
			if (foundFood.getName().equals(searchFood.getName())) {
				found = true;
			}
		}
		return (found==true);
		
	}
}

package be.belfius.zoo;

import java.util.Iterator;
import java.util.List;

import be.belfius.zoo.domain.DietByAnimalType;
import be.belfius.zoo.domain.Food;
import be.belfius.zoo.domain.enums.AnimalType;
import be.belfius.zoo.exceptions.DietNotFoundException;
import be.belfius.zoo.exceptions.FoodisEmptyException;
import be.belfius.zoo.exceptions.InvalidAnimalException;
import be.belfius.zoo.exceptions.InvalidAnimalTypeException;
import be.belfius.zoo.exceptions.InvalidFoodException;
import be.belfius.zoo.services.AnimalService;
import be.belfius.zoo.services.FoodService;
import be.belfius.zoo.services.MyScanner;

public class Menu {
	public String menuChoice;
	public String mAnimalType;
	public String mAnimalName;
	public String mFoodName;
	public String[] foodParts;
	public int mAmount;

	public void loopMenu(AnimalService animalService, FoodService foodService) {

		do {
			menuChoice = showmenu();
			System.out.println();

			switch (menuChoice) {
			case "1":
				createAnimalIO();
				try {
					animalService.createAnimal(mAnimalType, mAnimalName);
				} catch (InvalidAnimalTypeException e) {
					System.out.println("");
					System.out.println(e.getMessage());
				}
				break;

			case "2":
				delAnimalIO(animalService);
				if (animalService.deleteAnimal(mAnimalName) == true) {
					System.out.println(mAnimalName + " has left us.");
				} else {
					System.out.println(mAnimalName + " lives not in our Zoo.");
				}
				break;

			case "3":
				findAnimalsByTypeIO();
				try {
					System.out.println(animalService.findAnimalsPerType(mAnimalType));
				} catch (InvalidAnimalTypeException e) {
					System.out.println(e.getMessage());
				}
				break;

			case "4":
				for (Food food : foodService.getAllFood()) {
					System.out.println(food);
				}
				break;

			case "5":
				List<DietByAnimalType> temp = foodService.getAllDiets();

				for (int i = 0; i < temp.size(); i++) {
					System.out.println(temp.get(i));
				}
				break;

			case "6":
				addFoodIo();
				foodService.addFood(foodParts[0], foodParts[1], foodParts[2], foodParts[3]);
				break;

			case "7":
				addDietIO(foodService);
				try {
					foodService.addDiet(mAnimalType, mFoodName, mAmount);
				} catch (InvalidAnimalTypeException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());
				} catch (InvalidFoodException e2) {
					System.out.println(e2.getMessage());
				}
				break;

			case "8":
				Food foodForStock = updateFoodStockIO(foodService);
				if (foodService.updateFoodStock(foodForStock) == true) {
					continue;
				} else {
					System.out.println("Sorry, we don't have " + foodForStock.getName() + " in our Zoo !");
				}
				break;

			case "9":
				feedOneAnimalIO(animalService);
				try {
					foodService.feedOneAnimal(mAnimalName, animalService);
				} catch (InvalidAnimalException e) {
					System.out.println(e.getMessage());
				} catch (DietNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (FoodisEmptyException e) {
					System.out.println(e.getMessage());
				}
				break;

			case "X":
				System.out.println("Thank you for visiting our Zoo");
				break;

			default:
				System.out.println("Sorry, this choice is not supported.");
			}

		} while (!menuChoice.contentEquals("X"));

	}

	private Food updateFoodStockIO(FoodService foodService) {
		Food foodToUpdate = new Food(null, 0, 0, null);
		System.out.println("Which type of Food do you want to update ? ");

		for (Food food : foodService.getAllFood()) {
			System.out.println(food);
		}

		System.out.println();
		foodToUpdate.setName(new MyScanner().receiveString(""));
		foodToUpdate.setPortions(new MyScanner().receiveInt("How many portions do you have in stock now ? "));
		return foodToUpdate;
	}

	private void feedOneAnimalIO(AnimalService animalService) {
		System.out.println("Following animals live in our Zoo : " + animalService.getAllAnimals());
		mAnimalName = (new MyScanner().receiveString("Which animal do you want to feed ? Please enter AnimalName : "));
	}

	private void findAnimalsByTypeIO() {
		System.out.println("Please enter a valid animalType : " + AnimalType.getValidAnimalTypes());
		mAnimalType = (new MyScanner().receiveString(""));
		System.out.println();
	}

	private void createAnimalIO() {
		System.out.println("FINE WELCOME TO OUR NEW FRIEND !");
		System.out.println();

		System.out.println("Please enter a valid animalType :" + AnimalType.getValidAnimalTypes());
		mAnimalType = (new MyScanner().receiveString(""));

		System.out.println();
		mAnimalName = (new MyScanner().receiveString("Please enter AnimalName : "));
	}

	private void delAnimalIO(AnimalService animalService) {
		System.out.println("Following animals live in our Zoo : " + animalService.getAllAnimals());
		mAnimalName = (new MyScanner().receiveString("Which animal will leave us ? Please enter AnimalName : "));
	}

	private void addFoodIo() {
		System.out.println("Please enter in this format name/calories/portions/type. Type can be Veg or Meat.");
		String newFood = (new MyScanner().receiveString(""));
		foodParts = newFood.split("/");
	}

	private void addDietIO(FoodService foodService) {
		System.out.println("You can add Diets for following animals : " + AnimalType.getValidAnimalTypes());
		System.out.println("For which animal will you introduce the diet ? ");
		System.out.println();
		mAnimalType = (new MyScanner().receiveString(""));

		System.out.println("What will " + mAnimalType + " eat ? You can choose " + foodService.getAllFood());
		mFoodName = (new MyScanner().receiveString(""));

		mAmount = (new MyScanner().receiveInt("How many portions will the " + mAnimalType + " eat ? "));
	}

	public String showmenu() {
		System.out.println();
		System.out.println("What do you want to do ? Please enter you choice : ");
		System.out.println("1 : Create Animal");
		System.out.println("2 : Delete Animal");
		System.out.println("3 : Find Animals by Type");
		System.out.println();
		System.out.println("4 : View Inventory of Food");
		System.out.println("5 : View Inventory of Diets");
		System.out.println("6 : Add Food");
		System.out.println("7 : Add Diet");
		System.out.println("8 : Update FoodStock");
		System.out.println("9 : Feed one animal");
		System.out.println();
		System.out.println("X : Exit Applic");
		return new MyScanner().receiveString("");
	}
}

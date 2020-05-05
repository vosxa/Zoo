package be.belfius.zoo.domain;

public class Food {
	private String name;
	private int calories;
	private int portions;
	private String foodType;
	

	public Food(String name, int calories, int portions, String foodType) {
		super();
		this.name = name;
		this.calories = calories;
		this.portions = portions;
		this.setFoodType(foodType);
	}

	public Food(Food origFood) {
		this.name=origFood.name;
		this.calories=origFood.calories;
		this.portions=origFood.portions;
		this.foodType=origFood.foodType;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}


	public int getCalories() {
		return calories;
	}
	
	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getPortions() {
		return portions;
	}

	public void setPortions(int portions) {
		this.portions = portions;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	@Override
	public String toString() {
			return name + "(" + foodType + " - " + portions + " portions)";
	}
	
	}

package be.belfius.zoo.exceptions;

public class FoodisEmptyException extends Exception {

	@Override
	public String getMessage() {
		return "We can't feed this animal, because there is not enough FoodStock.";
	}

}

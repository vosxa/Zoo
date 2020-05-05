package be.belfius.zoo.exceptions;

public class InvalidFoodException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "We have not that food in our stock. You can add it by using option 6. ";
	}
	

}

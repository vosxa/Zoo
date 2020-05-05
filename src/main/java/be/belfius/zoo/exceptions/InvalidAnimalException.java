package be.belfius.zoo.exceptions;

public class InvalidAnimalException extends Exception{
	public String animalName;
	private static final long serialVersionUID = 1L;
	

	public InvalidAnimalException(String animalName) {
		super();
		this.animalName = animalName;
	}


	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Sorry, " + animalName + " is not living here.";
	}	
}

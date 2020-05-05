package be.belfius.zoo.exceptions;
import be.belfius.zoo.domain.enums.*;



public class InvalidAnimalTypeException extends Exception {
	private static final long serialVersionUID = 1L;
	public String excAnimalType;

	public InvalidAnimalTypeException(String excAnimalType) {
		super();
		this.excAnimalType = excAnimalType;
	}

	@Override
	public String getMessage() {
		return "Sorry a " + excAnimalType + " is not welcome/lives not in our zoo. \rFollowing animals are very welcome :"
				+ (AnimalType.getValidAnimalTypes());
	}

	
	
	
}

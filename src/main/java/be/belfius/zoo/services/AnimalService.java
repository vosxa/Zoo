package be.belfius.zoo.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import be.belfius.zoo.domain.*;
import be.belfius.zoo.domain.enums.AnimalType;
import be.belfius.zoo.exceptions.InvalidAnimalTypeException;
import be.belfius.zoo.repository.AnimalRepository;

public class AnimalService {
	private AnimalRepository animalRepository = new AnimalRepository();
//	public class AnimalElement {
//		public AnimalElement(String animalType, String animalName) {
//			// TODO Auto-generated constructor stub
//		}
//	}

	private String enAnimalType = null;
	private String inAnimalName;

	public void createAnimal(String inAnimalType, String inAnimalName) throws InvalidAnimalTypeException {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", "root", "");) {
//			Connection connection = DriverManager.getConnection(Helper.loadPropertiesFile().getProperty("db.url"), "root", "root");
			Class.forName("com.mysql.cj.jdbc.Driver");

			PreparedStatement statement;
			statement = connection.prepareStatement("select count(*) from AnimalType where type = upper(?)");
			statement.setString(1, inAnimalType);
			Integer Count = statement.getMaxRows();
			Count = statement.getFetchSize();
//			Count = statement.

			if (Count == 0)
				throw new InvalidAnimalTypeException(inAnimalType);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}


	public boolean deleteAnimal(String inAnimalName) {
		Animal delAnimal = new Lion(enAnimalType, inAnimalName);

		delAnimal.setName(inAnimalName);

		return animalRepository.deleteAnimal(delAnimal);
	}

	public List<Animal> findAnimalsPerType(String inAnimalType) throws InvalidAnimalTypeException {
		Animal findAnimal = new Lion(enAnimalType, inAnimalName);

		/*
		 * for (AnimalType animalType : AnimalType.values()) { if
		 * (animalType.getAnimalDescr().equals(inAnimalType)) {
		 * findAnimal.setAnimalType(animalType); } } if
		 * (findAnimal.getAnimalType()==null) { throw new
		 * InvalidAnimalTypeException(inAnimalType); }
		 */ return animalRepository.findAnimalsByType(findAnimal);
	}

	public Map<String, String> getAllAnimals() {
		return animalRepository.getAllAnimals();
	}

//	public Animal getOneAnimal(Bear bear) {
//		return animalRepository.getOneAnimal(bear);
//	}

	/*
	 * public AnimalType findAnimalType(String inAnimalType) throws
	 * InvalidAnimalTypeException { Animal findAnimal = new Lion(enAnimalType,
	 * inAnimalName);
	 * 
	 * for (AnimalType animalType : AnimalType.values()) { if
	 * (animalType.getAnimalDescr().equals(inAnimalType)) {
	 * findAnimal.setAnimalType(animalType); } } if
	 * (findAnimal.getAnimalType()==null) { throw new
	 * InvalidAnimalTypeException(inAnimalType); } return
	 * findAnimal.getAnimalType(); }
	 */

}

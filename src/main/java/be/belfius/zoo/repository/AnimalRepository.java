package be.belfius.zoo.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import be.belfius.zoo.domain.Animal;
import be.belfius.zoo.domain.Bear;
import be.belfius.zoo.domain.Lion;
import be.belfius.zoo.domain.Snake;
import be.belfius.zoo.domain.Tiger;
import be.belfius.zoo.domain.enums.AnimalType;

import java.sql.*;

public class AnimalRepository {
	private List<Animal> animals = new ArrayList<>();
	private List<Animal> dbAnimals = new ArrayList<>();

	public List<Animal> getAllAnimals() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", "root", "");) {
//			Connection connection = DriverManager.getConnection(Helper.loadPropertiesFile().getProperty("db.url"), "root", "root");
			Class.forName("com.mysql.cj.jdbc.Driver");

			Statement statement = connection.createStatement();
			statement.execute("select * from Animal");
			ResultSet resultSet = statement.getResultSet();

			while (resultSet.next()) {
				switch (resultSet.getString("type")) {
				case "BEAR":
					Bear bear = new Bear(AnimalType.BEAR, resultSet.getString("name"));
					dbAnimals.add(bear);
					break;
				case "LION":
					Lion lion = new Lion(AnimalType.LION, resultSet.getString("name"));
					dbAnimals.add(lion);
					break;
				case "TIGER":
					Tiger tiger = new Tiger(AnimalType.TIGER, resultSet.getString("name"));
					dbAnimals.add(tiger);
					break;
				case "SNAKE":
					Snake snake = new Snake(AnimalType.SNAKE, resultSet.getString("name"));
					dbAnimals.add(snake);
					break;
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		sortByAnimalNames();
		return dbAnimals;
	}

	public void sortByAnimalNames() {
		Collections.sort(dbAnimals);
	}

	public Animal getOneAnimal(Animal getAnimal) {
		Animal foundAnimal = new Lion(null, null);
		for (Animal oneAnimal : animals) {
			if (oneAnimal.getName().equals(getAnimal.getName())) {
				foundAnimal = oneAnimal;
				continue;
			}
		}

		return foundAnimal;
	}

	public void addAnimal(Animal newAnimal) { // CREATE
		Animal local = null;
		local = getOneAnimal(newAnimal);
		if (local.getName() != null) {
			System.out.println(local.getName() + " lives already in our zoo. Please try again and enter another name.");
		} else {
			animals.add(newAnimal);
		}
	}

	public void updateAnimal(Animal updAnimal) { // UPDATE
		animals.set(animals.indexOf(updAnimal), updAnimal);
	}

	public boolean deleteAnimal(Animal delAnimal) {
		Animal local = null;
		local = getOneAnimal(delAnimal);
		if (local.getName() != null) {
			animals.remove(local);
			return true;

		} else {
			return false;
		}
	}

	public List<Animal> findAnimalsByType(Animal getAnimal) {
		List<Animal> foundAnimalsList = new ArrayList<>();

		for (Animal oneAnimal : animals) {
			if (oneAnimal.getAnimalType().equals(getAnimal.getAnimalType())) {
				foundAnimalsList.add(oneAnimal);
			}
		}
		return foundAnimalsList;
	}
}

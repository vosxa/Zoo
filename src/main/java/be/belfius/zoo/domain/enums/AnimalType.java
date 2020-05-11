package be.belfius.zoo.domain.enums;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import be.belfius.zoo.exceptions.InvalidAnimalTypeException;

public enum AnimalType {
	BEAR("Bear"), LION("Lion"), TIGER("Tiger"), SNAKE("Snake");

	private String animalDescr;

	private AnimalType(String animalDescr) {
		this.animalDescr = animalDescr;
	}

	public String getAnimalDescr() {
		return animalDescr;
	}

	public static AnimalType findAnimalTypefromDescr(String animalDesc) throws InvalidAnimalTypeException {
		AnimalType myReturn = null;
		for (AnimalType animalType : AnimalType.values()) {
			if (animalType.getAnimalDescr().equals(animalDesc)) {
				myReturn = animalType;
			}
		}

		if (myReturn == null) {
			throw new InvalidAnimalTypeException(animalDesc);
		}
		return myReturn;
	}

	public static String getValidAnimalTypes() {
		String myReturn = "";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", "root", "");) {
//			Connection connection = DriverManager.getConnection(Helper.loadPropertiesFile().getProperty("db.url"), "root", "root");
			Class.forName("com.mysql.cj.jdbc.Driver");

			Statement statement = connection.createStatement();
			statement.execute("select * from AnimalType");
			ResultSet resultSet = statement.getResultSet();

			while (resultSet.next()) {
				if (myReturn == "") myReturn = myReturn + resultSet.getString("type");
				else myReturn = myReturn + "," + resultSet.getString("type");
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return myReturn;
	}
}

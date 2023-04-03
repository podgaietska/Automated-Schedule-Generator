package edu.ucalgary.oop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {

    String url = "jdbc:mysql://localhost:3306/EWR";
    String username = "root";
    String password = "AxOmSaPe15092002"; // Enter your personal password

    ArrayList<Animal> animals = new ArrayList<>();

    try (Connection connection = DriverManager.getConnection(url, username, password)) {
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM ANIMALS");

      while (resultSet.next()) {
        int id = resultSet.getInt("AnimalId");
        String name = resultSet.getString("AnimalNickname");
        String species = resultSet.getString("AnimalSpecies");
        System.out.println("ID: " + id + ", Name: " + name + ", Species: " + species);
        animals.add(new Animal(id, name, species));
      }

    } catch (SQLException e) {
      System.out.println("Connection to the database failed. Try checking the password!");
      e.printStackTrace();
    }

    for (Animal animal : animals) {
      System.out.println(animal);
    }

  }
}
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
    ArrayList<Task> tasks = new ArrayList<>();

    try (Connection connection = DriverManager.getConnection(url, username, password)) {

      Statement animalsQuery = connection.createStatement();
      ResultSet animalsResultSet = animalsQuery.executeQuery("SELECT * FROM ANIMALS");

      while (animalsResultSet.next()) {
        int id = animalsResultSet.getInt("AnimalID");
        String name = animalsResultSet.getString("AnimalNickname");
        String species = animalsResultSet.getString("AnimalSpecies");
        animals.add(new Animal(id, name, species));
      }

      Statement tasksQuery = connection.createStatement();
      ResultSet tasksResultSet = tasksQuery.executeQuery("SELECT * FROM TASKS");

      while (tasksResultSet.next()) {
        int id = tasksResultSet.getInt("TaskID");
        String description = tasksResultSet.getString("Description");
        int duration = tasksResultSet.getInt("Duration");
        int maxWindow = tasksResultSet.getInt("MaxWindow");
        tasks.add(new Task(id, description, duration, maxWindow));
      }

    } catch (SQLException e) {
      System.out.println("Connection to the database failed. Try checking the password!");
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e);
      e.printStackTrace();
    }

    for (Animal animal : animals) {
      System.out.println(animal);
    }

    for (Task task : tasks) {
      System.out.println(task);
    }

  }
}
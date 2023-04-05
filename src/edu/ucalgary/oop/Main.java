package edu.ucalgary.oop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
  public static void main(String[] args) {

    String url = "jdbc:mysql://localhost:3306/EWR";
    String username = "root";
    String password = "Barcelona15"; // Enter your personal password

    ArrayList<Animal> animals = new ArrayList<>();
    ArrayList<Task> tasks = new ArrayList<>();
    ArrayList<Treatment> treatments = new ArrayList<>();

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

      Statement treatmentsQuery = connection.createStatement();
      ResultSet treatmentsResultSet = treatmentsQuery.executeQuery("SELECT * FROM TREATMENTS");

      while (treatmentsResultSet.next()) {
        int id = treatmentsResultSet.getInt("TreatmentID");
        int animalId = treatmentsResultSet.getInt("AnimalID");
        int taskId = treatmentsResultSet.getInt("TaskID");
        int startHour = treatmentsResultSet.getInt("StartHour");

        for (Animal animal : animals)
          if (animal.getID() == animalId)
            for (Task task : tasks)
              if (task.getID() == taskId)
                treatments.add(new Treatment(id, animal, task, startHour));
      }

    } catch (SQLException e) {
      System.out.println("Connection to the database failed. Try checking the password!");
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e);
      e.printStackTrace();
    }

    Schedule schedule = new Schedule();

    schedule.addAnimals(animals);

    for (Animal animal : animals) {
      if (animal.getFeedingSchedule() != null)
        schedule.addFeeding(animal.getFeedingSchedule());
      schedule.addCageCleaning(animal.getCleaningCage());
    }

    for (Treatment treatment : treatments) {
      schedule.addTreatment(treatment);
    }

    schedule.addTasksToSchedule();

    schedule.addCageCleaningToSchedule();

    schedule.addFeedingToSchedule();

    schedule.printSchedule();

    EventQueue.invokeLater(() -> {
      JFrame frame = new JFrame("Animal Care Schedule");
      frame.setSize(800, 600);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JLabel title = new JLabel("Welcome to the Animal Wildlife Rescue Centre Database!", SwingConstants.CENTER);
      JLabel instruction = new JLabel("What would you like to do?", SwingConstants.CENTER);

      JPanel panel = new JPanel(new BorderLayout());

      JPanel topPanel = new JPanel(new GridLayout(2, 1));
      topPanel.add(title);
      topPanel.add(instruction);
      panel.add(topPanel, BorderLayout.NORTH);

      JTextArea textArea = new JTextArea();
      textArea.setEditable(false);
      JScrollPane scrollPane = new JScrollPane(textArea);
      panel.add(scrollPane, BorderLayout.CENTER);

      JButton scheduleButton = new JButton("Generate Schedule");
      scheduleButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          // Generate the schedule and display it in the text area
          String scheduleString = schedule.printSchedule(); // get the string representation of the schedule
          textArea.setText(scheduleString); // set the text area to display the schedule string
        }
      });

      JButton listAnimalsButton = new JButton("List Animals in Shelter");
      listAnimalsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          // List the animals in the shelter and display them in the text area
          String animalListString = schedule.getAllNames(); // get the string representation of the animal list
          textArea.setText(animalListString); // set the text area to display the animal list string
        }
      });

      JPanel buttonPanel = new JPanel(new FlowLayout());
      buttonPanel.add(scheduleButton);
      buttonPanel.add(listAnimalsButton);
      panel.add(buttonPanel, BorderLayout.SOUTH);

      frame.add(panel);
      frame.setVisible(true);
    });

  }
}

package edu.ucalgary.oop;

public class Animal {
  private final int id;
  private final String name;
  private final String species;

  public Animal(int id, String name, String species) throws IllegalArgumentException {
    if (id <= 0 || name == null || name.trim().isEmpty() || species == null || species.trim().isEmpty()) {
      throw new IllegalArgumentException("Invalid input for Animal");
    }

    this.id = id;
    this.name = name;
    this.species = species;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getSpecies() {
    return species;
  }

  @Override
  public String toString() {
    return "ID: " + id + ", Name: " + name + ", Species: " + species;
  }
}

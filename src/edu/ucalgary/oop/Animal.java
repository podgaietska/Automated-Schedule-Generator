package edu.ucalgary.oop;

public class Animal {
  private int id;
  private String name;
  private String species;

  public Animal(int id, String name, String species) {
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

package edu.ucalgary.oop;

public class Animal {
  private final int id;
  private final String name;
  private final String species;
  private final String type;
  private FeedingSchedule feedingSchedule;
  private CleaningCage cleaningCage;

  public Animal(int id, String name, String species) throws IllegalArgumentException {
    if (id <= 0 || name == null || name.trim().isEmpty() || species == null || species.trim().isEmpty()) {
      throw new IllegalArgumentException("Invalid input for Animal");
    }

    this.id = id;
    this.name = name;
    this.species = species;

    if (species.equals("fox") || species.equals("raccoon")) {
      this.type = "nocturnal";
    } else if (species.equals("coyote") || species.equals("porcupine")) {
      this.type = "crepescular";
    } else {
      this.type = "diurnal";
    }

    this.feedingSchedule = new FeedingSchedule(this.name, this.species, this.type);
    this.cleaningCage = new CleaningCage(this.name, this.species);
  }

  public int getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getSpecies() {
    return this.species;
  }

  public String getType() {
    return this.type;
  }

  public FeedingSchedule getFeedingSchedule() {
    return this.feedingSchedule;
  }

  public CleaningCage getCleaningCage() {
    return this.cleaningCage;
  }

  @Override
  public String toString() {
    return "ID: " + id + ", Name: " + name + ", Species: " + species + ", Type: " + type;
  }
}

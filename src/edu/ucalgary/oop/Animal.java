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

    if (species.equals("fox") || species.equals("racoon"))
      this.type = "nocturnal";
    else if (species.equals("coyote") || species.equals("porcupine"))
      this.type = "crepescular";
    else
      this.type = "diurnal";

    this.feedingSchedule = new FeedingSchedule(this.species, this.type);
    this.cleaningCage = new CleaningCage(this.species);
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

  public String getType() {
    return type;
  }

  public FeedingSchedule getFeedingSchedule() {
    return feedingSchedule;
  }

  @Override
  public String toString() {
    return "ID: " + id + ", Name: " + name + ", Species: " + species + ", Type: " + type;
  }
}

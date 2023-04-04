package edu.ucalgary.oop;

public class Animal {
  private final int ID;
  private final String NAME;
  private final String SPECIES;
  private final String TYPE;
  private FeedingSchedule feedingSchedule;
  private CleaningCage cleaningCage;

  public Animal(int ID, String NAME, String SPECIES) throws IllegalArgumentException {
    if (ID <= 0 || NAME == null || NAME.trim().isEmpty() || SPECIES == null || SPECIES.trim().isEmpty()) {
      throw new IllegalArgumentException("Invalid input for Animal");
    }

    this.ID = ID;
    this.NAME = NAME;
    this.SPECIES = SPECIES;

    if (SPECIES.equals("fox") || SPECIES.equals("racoon")) {
      this.TYPE = "nocturnal";
    } else if (SPECIES.equals("coyote") || SPECIES.equals("porcupine")) {
      this.TYPE = "crepescular";
    } else {
      this.TYPE = "diurnal";
    }

    this.feedingSchedule = new FeedingSchedule(this.NAME, this.SPECIES, this.TYPE);
    this.cleaningCage = new CleaningCage(this.NAME, this.SPECIES);
  }

  public int getID() {
    return this.ID;
  }

  public String getNAME() {
    return this.NAME;
  }

  public String getSPECIES() {
    return this.SPECIES;
  }

  public String getTYPE() {
    return this.TYPE;
  }

  public FeedingSchedule getFeedingSchedule() {
    return this.feedingSchedule;
  }

  public CleaningCage getCleaningCage() {
    return this.cleaningCage;
  }


  @Override
  public String toString() {
    return "ID: " + ID + ", Name: " + NAME + ", Species: " + SPECIES + ", Type: " + TYPE;
  }
}

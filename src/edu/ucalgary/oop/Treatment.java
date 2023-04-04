package edu.ucalgary.oop;

public class Treatment {
  private final int ID;
  private final Animal ANIMAL;
  private final Task TASK;
  private final int START_HOUR;

  public Treatment(int ID, Animal ANIMAL, Task TASK, int START_HOUR) throws IllegalArgumentException {
    if (ID == 0 || ANIMAL == null || TASK == null || START_HOUR < 0) {
      throw new IllegalArgumentException("All fields must be filled out");
    }

    this.ID = ID;
    this.ANIMAL = ANIMAL;
    this.TASK = TASK;
    this.START_HOUR = START_HOUR;

  }

  public int getID() {
    return this.ID;
  }

  public Animal getANIMAL() {
    return this.ANIMAL;
  }

  public Task getTASK() {
    return this.TASK;
  }

  public int getSTART_HOUR() {
    return this.START_HOUR;
  }

  @Override
  public String toString() {
    return "ANIMAL name: " + ANIMAL.getNAME() + ", Task description: " + TASK.getDescription() + ", Start Hour: "
        + START_HOUR + ", Duration: " + TASK.getDuration() + ", Max Window: " + TASK.getMaxWindow();
  }
}

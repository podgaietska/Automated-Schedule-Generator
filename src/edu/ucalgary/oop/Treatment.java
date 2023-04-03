package edu.ucalgary.oop;

public class Treatment {
  private final int id;
  private final int animalId;
  private final int taskId;
  private final int startHour;

  public Treatment(int id, int animalId, int taskId, int startHour) throws IllegalArgumentException {
    if (id == 0 || animalId == 0 || taskId == 0 || startHour < 0) {
      throw new IllegalArgumentException("All fields must be filled out");
    }
    this.id = id;
    this.animalId = animalId;
    this.taskId = taskId;
    this.startHour = startHour;
  }

  public long getId() {
    return id;
  }

  public int getAnimalId() {
    return animalId;
  }

  public int getTaskId() {
    return taskId;
  }

  public int getStartHour() {
    return startHour;
  }

  @Override
  public String toString() {
    return "ID: " + id + ", AnimalID: " + animalId + ", TaskID: " + taskId + ", Start Hour: " + startHour;
  }
}

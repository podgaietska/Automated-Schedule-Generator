package edu.ucalgary.oop;

public class Treatment {
  private final int id;
  private final Animal animal;
  private final Task task;
  private final int startHour;

  public Treatment(int id, Animal animal, Task task, int startHour) throws IllegalArgumentException {
    if (id == 0 || animal == null || task == null || startHour < 0) {
      throw new IllegalArgumentException("All fields must be filled out");
    }

    this.id = id;
    this.animal = animal;
    this.task = task;
    this.startHour = startHour;
 
  }

  public long getId() {
    return id;
  }


  @Override
  public String toString() {
    return "ID: " + id + ", AnimalID: " + animal.getId() + ", TaskID: " + task.getId() + ", Start Hour: " + startHour;
  }
}

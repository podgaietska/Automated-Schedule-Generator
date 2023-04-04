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

  public int getId() {
    return this.id;
  }

  public Animal getAnimal() {
    return this.animal;
  }

  public Task getTask() {
    return this.task;
  }

  public int getStartHour() {
    return this.startHour;
  }

  @Override
  public String toString() {
    return "Animal name: " + animal.getName() + ", Task description: " + task.getDescription() + ", Start Hour: "
        + startHour + ", Duration: " + task.getDuration() + ", Max Window: " + task.getMaxWindow();
  }
}

package edu.ucalgary.oop;

public class Treatment {
  private long id;
  private Animal animal;
  private Task task;
  private int startTime;
  private boolean backupVolunteer;

  public Treatment(long id, Animal animal, Task task, int startTime) throws IllegalArgumentException {
    if (id == 0 || animal == null || task == null || startTime == 0) {
      throw new IllegalArgumentException("All fields must be filled out");
    }
    this.id = id;
    this.animal = animal;
    this.task = task;
    this.startTime = startTime;
    this.backupVolunteer = false;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Animal getAnimal() {
    return animal;
  }

  public void setAnimal(Animal animal) {
    this.animal = animal;
  }

  public Task getTask() {
    return task;
  }

  public void setTask(Task task) {
    this.task = task;
  }

  public int getStartTime() {
    return startTime;
  }

  public void setStartTime(int startTime) {
    this.startTime = startTime;
  }

  public boolean isBackupVolunteer() {
    return backupVolunteer;
  }

  public void setBackupVolunteer(boolean backupVolunteer) {
    this.backupVolunteer = backupVolunteer;
  }
}

package edu.ucalgary.oop;

public class Treatment {
  private int id;
  private int animalId;
  private int taskId;
  private int startHour;
  // private boolean backupVolunteer;

  public Treatment(int id, int animalId, int taskId, int startHour) throws IllegalArgumentException {
    if (id == 0 || animalId == 0 || taskId == 0 || startHour < 0) {
      throw new IllegalArgumentException("All fields must be filled out");
    }
    this.id = id;
    this.animalId = animalId;
    this.taskId = taskId;
    this.startHour = startHour;
    // this.backupVolunteer = false;
  }

  public long getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getAnimalId() {
    return animalId;
  }

  public void setAnimal(int animalId) {
    this.animalId = animalId;
  }

  public int getTaskId() {
    return taskId;
  }

  public void setTask(int taskId) {
    this.taskId = taskId;
  }

  public int getStartHour() {
    return startHour;
  }

  public void setStartTime(int startHour) {
    this.startHour = startHour;
  }

  @Override
  public String toString() {
    return "ID: " + id + ", AnimalID: " + animalId + ", TaskID: " + taskId + ", Start Hour: " + startHour;
  }

  // public boolean isBackupVolunteer() {
  // return backupVolunteer;
  // }

  // public void setBackupVolunteer(boolean backupVolunteer) {
  // this.backupVolunteer = backupVolunteer;
  // }
}

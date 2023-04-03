package edu.ucalgary.oop;

public class Task {
  private final int id;
  private final String description;
  private final int duration;
  private final int maxWindow;

  public Task(int id, String description, int duration, int maxWindow) throws IllegalArgumentException {
    if (id <= 0 || description == null || description.trim().isEmpty() || duration <= 0 || maxWindow <= 0) {
      throw new IllegalArgumentException("Invalid input for Task");
    }

    this.id = id;
    this.description = description;
    this.duration = duration;
    this.maxWindow = maxWindow;
  }

  public int getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public int getDuration() {
    return duration;
  }

  public int getMaxWindow() {
    return maxWindow;
  }

  @Override
  public String toString() {
    return "ID: " + id + ", Description: " + description + ", Duration: " + duration + ", Max Window: " + maxWindow;
  }
}

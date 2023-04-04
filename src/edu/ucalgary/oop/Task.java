package edu.ucalgary.oop;
/**
 * The Task class is used for the Main Java file. It takes in
 * an animal Id, the Animal object, the Task object and the start hour for the
 * respective treatment being done per. animal.
 * 
 * @author Group 4
 * @since 2023-03-23
 */
public class Task {
  private final int ID;
  private final String DESCRIPTION;
  private final int DURATION;
  private final int MAXWINDOW;

  public Task(int ID, String DESCRIPTION, int DURATION, int MAXWINDOW) throws IllegalArgumentException {
    if (ID <= 0 || DESCRIPTION == null || DESCRIPTION.trim().isEmpty() || DURATION <= 0 || MAXWINDOW <= 0) {
      throw new IllegalArgumentException("Invalid input for Task");
    }

    this.ID = ID;
    this.DESCRIPTION = DESCRIPTION;
    this.DURATION = DURATION;
    this.MAXWINDOW = MAXWINDOW;
  }

  public int getID() {
    return ID;
  }

  public String getDESCRIPTION() {
    return DESCRIPTION;
  }

  public int getDURATION() {
    return DURATION;
  }

  public int getMAXWINDOW() {
    return MAXWINDOW;
  }

  @Override
  public String toString() {
    return "ID: " + ID + ", Description: " + DESCRIPTION + ", Duration: " + DURATION + ", Max Window: " + MAXWINDOW;
  }
}

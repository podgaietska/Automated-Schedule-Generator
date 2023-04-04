package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreatmentTest {
  private Animal testAnimal;
  private Task testTask;

  @Before
  public void setUp() {
    testAnimal = new Animal(1, "Test Animal", "Test Species");
    testTask = new Task(1, "Test Task", 30, 4);
  }

  @Test
  public void testValidTreatmentCreation() {
    Treatment treatment = new Treatment(1, testAnimal, testTask, 2);

    assertEquals(1, treatment.getId());
    assertEquals(testAnimal, treatment.getAnimal());
    assertEquals(testTask, treatment.getTask());
    assertEquals(2, treatment.getStartHour());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidTreatmentCreation() {
    new Treatment(0, null, null, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidTreatmentCreationInvalidId() {
    new Treatment(0, testAnimal, testTask, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidTreatmentCreationNullAnimal() {
    new Treatment(1, null, testTask, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidTreatmentCreationNullTask() {
    new Treatment(1, testAnimal, null, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidTreatmentCreationNegativeStartHour() {
    new Treatment(1, testAnimal, testTask, -1);
  }
}

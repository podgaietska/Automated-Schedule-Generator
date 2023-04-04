package test.edu.ucalgary.oop;

import org.junit.Test;

import edu.ucalgary.oop.Animal;

import static org.junit.Assert.*;

public class AnimalTest {

  @Test
  public void testValidAnimalCreation() {
    Animal animal = new Animal(1, "Test Animal", "fox");

    assertEquals(1, animal.getId());
    assertEquals("Test Animal", animal.getName());
    assertEquals("fox", animal.getSpecies());
    assertEquals("nocturnal", animal.getType());
    assertNotNull(animal.getFeedingSchedule());
    assertNotNull(animal.getCleaningCage());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAnimalCreation() {
    new Animal(0, null, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAnimalCreationInvalidId() {
    new Animal(0, "Test Animal", "fox");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAnimalCreationEmptyName() {
    new Animal(1, "", "fox");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAnimalCreationNullName() {
    new Animal(1, null, "fox");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAnimalCreationEmptySpecies() {
    new Animal(1, "Test Animal", "");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAnimalCreationNullSpecies() {
    new Animal(1, "Test Animal", null);
  }

  // You can add additional test cases for other species and types as necessary.
}

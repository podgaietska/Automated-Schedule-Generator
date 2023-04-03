package test.edu.ucalgary.oop;

import org.junit.Test;

import edu.ucalgary.oop.Animal;

public class AnimalTest {

  @Test
  public void testAnimalConstructorValidInput() {
    Animal animal = new Animal(1, "Fluffy", "Cat");
    assert animal.getId() == 1;
    assert animal.getName().equals("Fluffy");
    assert animal.getSpecies().equals("Cat");
  }

  @Test
  public void testAnimalConstructorInvalidId() {
    try {
      Animal animal = new Animal(-1, "Fluffy", "Cat");
      assert false : "Expected IllegalArgumentException for invalid ID";
    } catch (IllegalArgumentException e) {
      assert e.getMessage().equals("Invalid input for Animal");
    }
  }

  @Test
  public void testAnimalConstructorNullName() {
    try {
      Animal animal = new Animal(1, null, "Cat");
      assert false : "Expected IllegalArgumentException for null name";
    } catch (IllegalArgumentException e) {
      assert e.getMessage().equals("Invalid input for Animal");
    }
  }

  @Test
  public void testAnimalConstructorEmptyName() {
    try {
      Animal animal = new Animal(1, " ", "Cat");
      assert false : "Expected IllegalArgumentException for empty name";
    } catch (IllegalArgumentException e) {
      assert e.getMessage().equals("Invalid input for Animal");
    }
  }

  @Test
  public void testAnimalConstructorNullSpecies() {
    try {
      Animal animal = new Animal(1, "Fluffy", null);
      assert false : "Expected IllegalArgumentException for null species";
    } catch (IllegalArgumentException e) {
      assert e.getMessage().equals("Invalid input for Animal");
    }
  }

  @Test
  public void testAnimalConstructorEmptySpecies() {
    try {
      Animal animal = new Animal(1, "Fluffy", " ");
      assert false : "Expected IllegalArgumentException for empty species";
    } catch (IllegalArgumentException e) {
      assert e.getMessage().equals("Invalid input for Animal");
    }
  }

  @Test
  public void testToString() {
    Animal animal = new Animal(1, "Fluffy", "Cat");
    String expected = "ID: 1, Name: Fluffy, Species: Cat";
    assert animal.toString().equals(expected);
  }
}

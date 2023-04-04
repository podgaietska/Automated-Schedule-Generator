package edu.ucalgary.oop;

import org.junit.Test;

import static org.junit.Assert.*;

public class CleaningCageTest {

  @Test
  public void testDurationForPorcupine() {
    CleaningCage cleaningCage = new CleaningCage("porcupine");

    assertEquals(10, cleaningCage.getDuration());
  }

  @Test
  public void testDurationForOtherSpecies() {
    CleaningCage cleaningCage = new CleaningCage("fox");

    assertEquals(5, cleaningCage.getDuration());
  }

  @Test
  public void testToString() {
    CleaningCage cleaningCage = new CleaningCage("porcupine");

    assertEquals("Cleaning Cage Duration: 10", cleaningCage.toString());
  }

}

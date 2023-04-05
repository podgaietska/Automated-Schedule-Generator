package edu.ucalgary.oop;

import org.junit.Test;
import org.junit.Assert;

public class CleaningCageTest {

  @Test
  public void testCleaningCageConstructor() {
    CleaningCage cleaningCage = new CleaningCage("Mowgli", "fox");
    Assert.assertEquals("fox", cleaningCage.getSpecies());
    Assert.assertEquals("Mowgli", cleaningCage.getName());
    Assert.assertEquals(5, cleaningCage.getDuration());
    Assert.assertEquals("clean cage for fox", cleaningCage.getDescription());
  }

  @Test
  public void testCleaningCageDurationPorcupine() {
    CleaningCage cleaningCage = new CleaningCage("Spiky", "porcupine");
    Assert.assertEquals(10, cleaningCage.getDuration());
  }

  @Test
  public void testCleaningCageDurationOtherSpecies() {
    CleaningCage cleaningCage = new CleaningCage("Mowgli", "fox");
    Assert.assertEquals(5, cleaningCage.getDuration());
  }

  @Test
  public void testCleaningCageToString() {
    CleaningCage cleaningCage = new CleaningCage("Mowgli", "fox");
    String expected = "To clean cage for: Mowgli, Duration: 5";
    Assert.assertEquals(expected, cleaningCage.toString());
  }
}

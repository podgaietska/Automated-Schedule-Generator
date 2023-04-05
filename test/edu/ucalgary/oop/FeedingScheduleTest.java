package edu.ucalgary.oop;

import org.junit.Test;
import org.junit.Assert;

public class FeedingScheduleTest {

  @Test
  public void testFeedingScheduleConstructor() {
    FeedingSchedule feedingSchedule = new FeedingSchedule("Oliver", "fox", "nocturnal");
    Assert.assertEquals("fox", feedingSchedule.getSpecies());
    Assert.assertEquals("Oliver", feedingSchedule.getName());
    Assert.assertEquals(5, feedingSchedule.getDuration());
    Assert.assertEquals(0, feedingSchedule.getStartHour());
    Assert.assertEquals(3, feedingSchedule.getTimeWindow());
    Assert.assertEquals(0, feedingSchedule.getPrep());
    Assert.assertEquals("feed fox", feedingSchedule.getDescription());
  }

  @Test
  public void testFeedingScheduleDifferentTypes() {
    FeedingSchedule crepescularFeeding = new FeedingSchedule("Spiky", "porcupine", "crepescular");
    Assert.assertEquals(19, crepescularFeeding.getStartHour());

    FeedingSchedule diurnalFeeding = new FeedingSchedule("Beavy", "beaver", "diurnal");
    Assert.assertEquals(8, diurnalFeeding.getStartHour());
  }

  @Test
  public void testFeedingSchedulePrepTime() {
    FeedingSchedule coyoteFeeding = new FeedingSchedule("Wiley", "coyote", "crepescular");
    Assert.assertEquals(10, coyoteFeeding.getPrep());

    FeedingSchedule foxFeeding = new FeedingSchedule("Oliver", "fox", "nocturnal");
    Assert.assertEquals(0, foxFeeding.getPrep());
  }

  @Test
  public void testFeedingScheduleToString() {
    FeedingSchedule feedingSchedule = new FeedingSchedule("Oliver", "fox", "nocturnal");
    String expected = "To feed Oliver, Start time: 0, Time Window: 3, Duration: 5, Prep: 0";
    Assert.assertEquals(expected, feedingSchedule.toString());
  }
}

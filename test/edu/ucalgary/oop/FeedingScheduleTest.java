package edu.ucalgary.oop;

import org.junit.Test;

import static org.junit.Assert.*;

public class FeedingScheduleTest {

  @Test
  public void testFeedingScheduleForCrepescularSpecies() {
    FeedingSchedule feedingSchedule = new FeedingSchedule("coyote", "crepescular");

    assertEquals(5, feedingSchedule.getDuration());
    assertEquals(19, feedingSchedule.getStartHour());
    assertEquals(3, feedingSchedule.getTimeWindow());
    assertEquals(10, feedingSchedule.getPrep());
  }

  @Test
  public void testFeedingScheduleForNocturnalSpecies() {
    FeedingSchedule feedingSchedule = new FeedingSchedule("racoon", "nocturnal");

    assertEquals(5, feedingSchedule.getDuration());
    assertEquals(0, feedingSchedule.getStartHour());
    assertEquals(3, feedingSchedule.getTimeWindow());
    assertEquals(0, feedingSchedule.getPrep());
  }

  @Test
  public void testFeedingScheduleForDiurnalSpecies() {
    FeedingSchedule feedingSchedule = new FeedingSchedule("beaver", "diurnal");

    assertEquals(5, feedingSchedule.getDuration());
    assertEquals(8, feedingSchedule.getStartHour());
    assertEquals(3, feedingSchedule.getTimeWindow());
    assertEquals(0, feedingSchedule.getPrep());
  }

  @Test
  public void testToString() {
    FeedingSchedule feedingSchedule = new FeedingSchedule("coyote", "crepescular");

    assertEquals("To feed:coyote, Start time: 19, Time Window: 3, Duration: 5, Prep: 10", feedingSchedule.toString());
  }

}

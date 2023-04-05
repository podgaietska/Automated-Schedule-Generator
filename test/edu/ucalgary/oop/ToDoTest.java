package edu.ucalgary.oop;

import org.junit.Test;
import org.junit.Assert;

public class ToDoTest {

  @Test
  public void testToDoConstructor() {
    ToDo toDo = new ToDo();
    Assert.assertEquals(60, toDo.getTimeRemaining());
    Assert.assertEquals("", toDo.getTasks());
  }

  @Test
  public void testAddTask() {
    ToDo toDo = new ToDo();
    toDo.addTask("feed animals");
    Assert.assertEquals("feed animals, ", toDo.getTasks());
  }

  @Test
  public void testUpdateTimeRemaining() {
    ToDo toDo = new ToDo();
    toDo.updateTimeRemaining(30);
    Assert.assertEquals(30, toDo.getTimeRemaining());
  }

  @Test
  public void testToString() {
    ToDo toDo = new ToDo();
    toDo.addTask("feed animals");
    toDo.updateTimeRemaining(30);
    String expected = "Task: feed animals, Time Remaining: 30";
    Assert.assertEquals(expected, toDo.toString());
  }
}

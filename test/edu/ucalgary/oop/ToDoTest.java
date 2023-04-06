package edu.ucalgary.oop;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class ToDoTest {

  @Test
  public void testGetToDoList() {
    ToDo toDo = new ToDo();
    assertNotNull(toDo.getToDoList());
    assertTrue(toDo.getToDoList() instanceof ArrayList);
  }

  @Test
  public void testAddTask() {
    ToDo toDo = new ToDo();
    toDo.addTask("Clean cage for porcupine");
    assertEquals(1, toDo.getToDoList().size());
    assertEquals("Clean cage for porcupine", toDo.getToDoList().get(0));
  }

  @Test
  public void testGetTimeRemaining() {
    ToDo toDo = new ToDo();
    assertEquals(60, toDo.getTimeRemaining());
  }

  @Test
  public void testUpdateTimeRemaining() {
    ToDo toDo = new ToDo();
    toDo.updateTimeRemaining(40);
    assertEquals(40, toDo.getTimeRemaining());
  }

  @Test
  public void testGetTasks() {
    ToDo toDo = new ToDo();
    toDo.addTask("Clean cage for porcupine");
    toDo.addTask("Feed raccoon");
    String expectedOutput = "* Clean cage for porcupine\n* Feed raccoon\n";
    assertEquals(expectedOutput, toDo.getTasks());
  }

  @Test
  public void testToString() {
    ToDo toDo = new ToDo();
    toDo.addTask("Clean cage for porcupine");
    toDo.addTask("Feed raccoon");
    String expectedOutput = "* Clean cage for porcupine\n* Feed raccoon\n";
    assertEquals(expectedOutput, toDo.toString());
  }
}

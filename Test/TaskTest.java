import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TaskTest {
    @Test
    public void testTaskConstructor() {

        long id = 1;
        String description = "Sample task";
        int duration = 60;
        int maxWindow = 120;

        Task task = new Task(id, description, duration, maxWindow);

        assertEquals("ID value mismatch.", id, task.getID());
        assertEquals("Description value mismatch.", description, task.getDESCRIPTION());
        assertEquals("Duration value mismatch.", duration, task.getDURATION());
        assertEquals("Max window value mismatch.", maxWindow, task.getMAX_WINDOW());

        System.out.println("testTaskConstructor: Task object created successfully with valid input values");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTaskConstructorThrowsIllegalArgumentExceptionOnInvalidID() {

        new Task(0, "Sample task", 60, 120);

        System.out.println("testTaskConstructorThrowsIllegalArgumentExceptionOnInvalidID: IllegalArgumentException thrown for invalid ID");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTaskConstructorThrowsIllegalArgumentExceptionOnInvalidDescription() {

        new Task(1, null, 60, 120);

        System.out.println("testTaskConstructorThrowsIllegalArgumentExceptionOnInvalidDescription: IllegalArgumentException thrown for invalid description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTaskConstructorThrowsIllegalArgumentExceptionOnInvalidDuration() {

        new Task(1, "Sample task", 0, 120);

        System.out.println("testTaskConstructorThrowsIllegalArgumentExceptionOnInvalidDuration: IllegalArgumentException thrown for invalid duration");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTaskConstructorThrowsIllegalArgumentExceptionOnInvalidMaxWindow() {

        new Task(1, "Sample task", 60, 0);

        System.out.println("testTaskConstructorThrowsIllegalArgumentExceptionOnInvalidMaxWindow: IllegalArgumentException thrown for invalid max window");
    }
}

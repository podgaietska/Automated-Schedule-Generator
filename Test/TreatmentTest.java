import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class TreatmentTest {
    @Test
    public void testTreatmentConstructor() {

        long treatmentId = 1;
        long animalId = 1;
        String animalName = "Lion";
        String species = "Panthera leo";
        String behavior = "Carnivore";
        int mealPreparationTime = 30;
        int timeToEat = 15;
        Animal animal = new Animal(animalId, animalName, species, behavior, mealPreparationTime, timeToEat);

        long taskId = 1;
        String description = "Sample task";
        int duration = 60;
        int maxWindow = 120;
        Task task = new Task(taskId, description, duration, maxWindow);

        int startTime = 10;

        Treatment treatment = new Treatment(treatmentId, animal, task, startTime);

        assertEquals("Treatment ID value mismatch.", treatmentId, treatment.getId());
        assertEquals("Animal value mismatch.", animal, treatment.getAnimal());
        assertEquals("Task value mismatch.", task, treatment.getTask());
        assertEquals("Start time value mismatch.", startTime, treatment.getStartTime());
        assertFalse("Backup volunteer value mismatch.", treatment.isBackupVolunteer());

        System.out.println("testTreatmentConstructor: Treatment object created successfully with valid input values");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTreatmentConstructorThrowsIllegalArgumentException() {

        new Treatment(1, null, null, 0);

        System.out.println("testTreatmentConstructorThrowsIllegalArgumentException: IllegalArgumentException thrown for invalid input values");
    }
}

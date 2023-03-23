import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.*;

public class TreatmentsTest {
    private ArrayList<Treatment> treatmentsList;
    private Animal animal;
    private Task task;

    @Before
    public void setUp() {
        animal = new Animal(1, "Black Panther", "Panther", "Nocturnal", 30, 15);
        task = new Task(1, "Sample task", 60, 120);

        treatmentsList = new ArrayList<>();
        treatmentsList.add(new Treatment(1, animal, task, 10));
        treatmentsList.add(new Treatment(2, animal, task, 15));
    }

    @Test
    public void testTreatmentsConstructor() {

        Treatments treatments = new Treatments(treatmentsList);

        assertNotNull("Treatments object should not be null.", treatments.getTreatments());
        assertEquals("Treatments list size mismatch.", treatmentsList.size(), treatments.getTreatments().size());

        System.out.println("testTreatmentsConstructor: Treatments object created successfully with valid input values");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTreatmentsConstructorThrowsIllegalArgumentException() {

        new Treatments(null);

        System.out.println("testTreatmentsConstructorThrowsIllegalArgumentException: IllegalArgumentException thrown for null treatments list");
    }

    @Test
    public void testGetTreatment() {
        Treatments treatments = new Treatments(treatmentsList);

        Treatment treatment1 = treatments.getTreatment(1);
        assertNotNull("Treatment 1 should not be null.", treatment1);
        assertEquals("Treatment 1 ID mismatch.", 1, treatment1.getId());

        Treatment treatment3 = treatments.getTreatment(3);
        assertNull("Treatment 3 should be null.", treatment3);

        System.out.println("testGetTreatment: getTreatment method returns correct treatment based on ID");
    }
}

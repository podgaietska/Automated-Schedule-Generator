import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AnimalTest {
    @Test
    public void testAnimalConstructor() {

        long id = 1;
        String name = "Black Panther";
        String species = "Panther";
        String behavior = "Nocturnal";
        int mealPreparationTime = 30;
        int timeToEat = 15;

        Animal animal = new Animal(id, name, species, behavior, mealPreparationTime, timeToEat);

        assertEquals("ID value mismatch.", id, animal.getID());
        assertEquals("Name value mismatch.", name, animal.getNAME());
        assertEquals("Species value mismatch.", species, animal.getSPECIES());
        assertEquals("Behavior value mismatch.", behavior, animal.getBEHAVIOR());
        assertEquals("Meal preparation time value mismatch.", mealPreparationTime, animal.getMEAL_PREPARATION_TIME());
        assertEquals("Time to eat value mismatch.", timeToEat, animal.getTIME_TO_EAT());

        System.out.println("testAnimalConstructor: Animal object created successfully with valid input values");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAnimalConstructorThrowsIllegalArgumentExceptionOnInvalidID() {

        new Animal(0, "Lion", "Panthera leo", "Carnivore", 30, 15);

        System.out.println("testAnimalConstructorThrowsIllegalArgumentExceptionOnInvalidID: IllegalArgumentException thrown for invalid ID");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAnimalConstructorThrowsIllegalArgumentExceptionOnInvalidName() {

        new Animal(1, null, "Panthera leo", "Carnivore", 30, 15);

        System.out.println("testAnimalConstructorThrowsIllegalArgumentExceptionOnInvalidName: IllegalArgumentException thrown for invalid name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAnimalConstructorThrowsIllegalArgumentExceptionOnInvalidSpecies() {

        new Animal(1, "Lion", null, "Carnivore", 30, 15);

        System.out.println("testAnimalConstructorThrowsIllegalArgumentExceptionOnInvalidSpecies: IllegalArgumentException thrown for invalid species");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAnimalConstructorThrowsIllegalArgumentExceptionOnInvalidBehavior() {

        new Animal(1, "Lion", "Panthera leo", null, 30, 15);

        System.out.println("testAnimalConstructorThrowsIllegalArgumentExceptionOnInvalidBehavior: IllegalArgumentException thrown for invalid behavior");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAnimalConstructorThrowsIllegalArgumentExceptionOnInvalidMealPreparationTime() {

        new Animal(1, "Lion", "Panthera leo", "Carnivore", 0, 15);

        System.out.println("testAnimalConstructorThrowsIllegalArgumentExceptionOnInvalidMealPreparationTime: IllegalArgumentException thrown for invalid meal preparation time");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAnimalConstructorThrowsIllegalArgumentExceptionOnInvalidTimeToEat() {

        new Animal(1, "Lion", "Panthera leo", "Carnivore", 30, 0);

        System.out.println("testAnimalConstructorThrowsIllegalArgumentExceptionOnInvalidTimeToEat: IllegalArgumentException thrown for invalid time to eat");
    }
}


package models;

public class Animal {
    private final long ID;
    private final String NAME;
    private final String SPECIES;
    private final String BEHAVIOR;
    private final int MEAL_PREPARATION_TIME;
    private final int TIME_TO_EAT;

    public Animal(long ID, String NAME, String SPECIES, String BEHAVIOR, int MEAL_PREPARATION_TIME, int TIME_TO_EAT) throws IllegalArgumentException {
        if (ID == 0 || NAME == null || SPECIES == null || BEHAVIOR == null || MEAL_PREPARATION_TIME == 0 || TIME_TO_EAT == 0) {
            throw new IllegalArgumentException("All fields must be filled out.");
        }
        this.ID = ID;
        this.NAME = NAME;
        this.SPECIES = SPECIES;
        this.BEHAVIOR = BEHAVIOR;
        this.MEAL_PREPARATION_TIME = MEAL_PREPARATION_TIME;
        this.TIME_TO_EAT = TIME_TO_EAT;
    }

    public long getID() {
        return ID;
    }

    public String getNAME() {
        return NAME;
    }

    public String getSPECIES() {
        return SPECIES;
    }

    public String getBEHAVIOR() {
        return BEHAVIOR;
    }

    public int getMEAL_PREPARATION_TIME() {
        return MEAL_PREPARATION_TIME;
    }

    public int getTIME_TO_EAT() {
        return TIME_TO_EAT;
    }
}

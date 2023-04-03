package edu.ucalgary.oop;

public class CleaningCage {

    private String species;
    private int duration;

    public CleaningCage(String species) {
        this.species = species;

        if (species.equals("porcupine"))
            this.duration = 10;
        else
            this.duration = 5;
    }
    
}

package edu.ucalgary.oop;

public class CleaningCage {
    private int duration;

    public CleaningCage(String species) {
        if (species.equals("porcupine"))
            this.duration = 10;
        else
            this.duration = 5;
    }

    public int getDuration() {
        return this.duration;
    }

    @Override
    public String toString() {
        return "Cleaning Cage Duration: " + duration;
    }

}

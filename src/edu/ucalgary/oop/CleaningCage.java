package edu.ucalgary.oop;

public class CleaningCage {

    private String species;
    private String name;
    private String description = "clean cage";
    private int duration;
    
    

    public CleaningCage(String name, String species) {
        this.species = species;
        this.name = name;

        if (species.equals("porcupine"))
            this.duration = 10;
        else
            this.duration = 5;
    }

    public int getDuration() {
        return duration;
    }

    public String getSpecies() {
        return species;
    }

    @Override
    public String toString() {
        return "To " + description + " for: " + name + ", Duration: " + duration;
      }
    
}

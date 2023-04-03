package edu.ucalgary.oop;

public class FeedingSchedule {
    private String species;
    private int duration;
    private int startHour;
    private int timeWindow;
    private int prep;

    public FeedingSchedule(String species, String type) {
        this.duration = 5;
        this.timeWindow = 3;
        this.species = species;

        if (type.equals("crepescular"))
            this.startHour = 19;
        else if (type.equals("nocturnal"))
            this.startHour = 0;
        else
            this.startHour = 8;

        if (species.equals("porcupine") || species.equals("racoon") || species.equals("beaver")){
            this.prep = 0;
        }
        else if (species.equals("coyote")){
            this.prep = 10;
        }
        else {
            this.prep = 0;
        }
            
    }

    public int getDuration() {
        return duration;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getTimeWindow() {
        return timeWindow;
    }
    
    public int getPrep() {
        return prep;
    }

    @Override
    public String toString() {
        return "To feed:" + species + ", Start time: " + startHour + ", Time Window: " + timeWindow + ", Duration: " + duration + ", Prep: " + prep;
      }

    
}

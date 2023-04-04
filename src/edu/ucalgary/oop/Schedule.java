package edu.ucalgary.oop;

import java.util.*;

public class Schedule {
    private HashMap<Integer, ToDo> schedule = new HashMap<Integer, ToDo>();
    private ArrayList<FeedingSchedule> feedings = new ArrayList<FeedingSchedule>();
    private ArrayList<CleaningCage> cageCleanings = new ArrayList<CleaningCage>();
    private ArrayList<Treatment> treatments = new ArrayList<Treatment>();;
    private HashMap<String, Integer> animalCount = new HashMap<>();

    public Schedule() {

        animalCount.put("coyote", 0);
        animalCount.put("porcupine", 0);
        animalCount.put("fox", 0);
        animalCount.put("racoon", 0);
        animalCount.put("beaver", 0);

        for (int i = 0; i < 24; i++) {
            schedule.put(i, new ToDo());
        }
    }

    public void addTasksToSchedule() {
        Collections.sort(treatments, Comparator.comparing(Treatment -> Treatment.getTask().getMaxWindow()));
        for (Treatment treatment : treatments) {
            int treatmentStartHour = treatment.getStartHour();
            int treatmentMaxWindow = treatment.getTask().getMaxWindow();
            if (treatmentMaxWindow == 1) {
                schedule.get(treatmentStartHour).addTask(treatment.getTask().getDescription());
                int newTimeRemaining = schedule.get(treatmentStartHour).getTimeRemaining()
                        - treatment.getTask().getDuration();
                schedule.get(treatmentStartHour).updateTimeRemaining(newTimeRemaining);
            }
            if (treatmentMaxWindow == 2) {
                if (schedule.get(treatmentStartHour).getTimeRemaining() < treatment.getTask().getDuration()) {
                    schedule.get(treatmentStartHour + 1).addTask(treatment.getTask().getDescription());
                    int newTimeRemaining = schedule.get(treatmentStartHour + 1).getTimeRemaining()
                            - treatment.getTask().getDuration();
                    schedule.get(treatmentStartHour + 1).updateTimeRemaining(newTimeRemaining);
                } else {
                    schedule.get(treatmentStartHour).addTask(treatment.getTask().getDescription());
                    int newTimeRemaining = schedule.get(treatmentStartHour).getTimeRemaining()
                            - treatment.getTask().getDuration();
                    schedule.get(treatmentStartHour).updateTimeRemaining(newTimeRemaining);
                }
            } else {
                if (treatmentMaxWindow > 2 && treatmentMaxWindow < 24) {
                    int i = treatmentStartHour;
                    while (i < treatmentMaxWindow && 1 - schedule.get(treatmentStartHour).getTimeRemaining()
                            - treatment.getTask().getDuration() >= 0) {
                        schedule.get(i).addTask(treatment.getTask().getDescription());
                        int newTimeRemaining = schedule.get(i).getTimeRemaining() - treatment.getTask().getDuration();
                        schedule.get(i).updateTimeRemaining(newTimeRemaining);
                        i++;
                    }
                }
            }
        }
    }

    public void addAnimals(ArrayList<Animal> animals) {
        for (Animal animal : animals) {
            if (animal.getSpecies().equals("porcupine")) {
                this.animalCount.put("porcupine", animalCount.get("porcupine") + 1);
            } else if (animal.getSpecies().equals("coyote")) {
                this.animalCount.put("coyote", animalCount.get("coyote") + 1);
            } else if (animal.getSpecies().equals("fox")) {
                this.animalCount.put("fox", animalCount.get("fox") + 1);
            } else if (animal.getSpecies().equals("racoon")) {
                this.animalCount.put("racoon", animalCount.get("racoon") + 1);
            } else if (animal.getSpecies().equals("beaver")) {
                this.animalCount.put("beaver", animalCount.get("beaver") + 1);
            }
        }
    }

    public void addFeeding(FeedingSchedule feeding) {
        feedings.add(feeding);
    }

    public void addCageCleaning(CleaningCage cageCleaning) {
        cageCleanings.add(cageCleaning);
    }

    public void addTreatment(Treatment treatment) {
        treatments.add(treatment);
    }

    public ArrayList<Treatment> getTreatment() {
        return treatments;
    }

    public ArrayList<FeedingSchedule> getFeeding() {
        return feedings;
    }

    public ArrayList<CleaningCage> getCageCleaning() {
        return cageCleanings;
    }

    public HashMap<String, Integer> getAnimalCount() {
        return animalCount;
    }

    public HashMap<Integer, ToDo> getSchedule() {
        return schedule;
    }
}

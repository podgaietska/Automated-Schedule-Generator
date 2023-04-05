package edu.ucalgary.oop;

import java.io.*;
import java.util.*;

/**
 * The Schedule class is used to organize the tasks/feedings/etc. of
 * each animal into a generated, readable schedule, for this project.
 * 
 * @author Nicole Izdraila, Mariia Podgaietska, Afrah Mohammad, Axel Sanchez
 * @since 2023-03-23
 */
public class Schedule {
    private HashMap<Integer, ToDo> schedule = new HashMap<Integer, ToDo>();
    private ArrayList<FeedingSchedule> feedings = new ArrayList<FeedingSchedule>();
    private ArrayList<CleaningCage> cageCleanings = new ArrayList<CleaningCage>();
    private ArrayList<Treatment> treatments = new ArrayList<Treatment>();;
    private HashMap<String, Integer> animalCount = new HashMap<>();

    /**
     * constructor for Schedule class
     */
    public Schedule() {
        animalCount.put("coyote", 0);
        animalCount.put("porcupine", 0);
        animalCount.put("fox", 0);
        animalCount.put("raccoon", 0);
        animalCount.put("beaver", 0);

        for (int i = 0; i < 24; i++) {
            schedule.put(i, new ToDo());
        }
    }

    /**
     * adds corresponding tasks to the schedule, and calculates the time
     * respective to the tasks added
     */
    public void addTasksToSchedule() {
        Collections.sort(treatments, Comparator.comparing(Treatment -> Treatment.getTASK().getMAXWINDOW()));

        for (Treatment treatment : treatments) {
            int treatmentStartHour = treatment.getSTART_HOUR();
            int treatmentMaxWindow = treatment.getTASK().getMAXWINDOW();

            int currentWindow = 0;
            while (currentWindow < treatmentMaxWindow) {
                int currentHour = treatmentStartHour + currentWindow;
                if (schedule.get(currentHour).getTimeRemaining() >= treatment.getTASK().getDURATION()) {
                    schedule.get(currentHour).addTask(
                            treatment.getTASK().getDESCRIPTION() + " (" + treatment.getANIMAL().getNAME() + ")");
                    int newTimeRemaining = schedule.get(currentHour).getTimeRemaining()
                            - treatment.getTASK().getDURATION();
                    schedule.get(currentHour).updateTimeRemaining(newTimeRemaining);
                    break;
                } else {
                    currentWindow++;
                }
            }
        }
    }

    /**
     * adds corresponding feeding times to the schedule, and
     * calculates the time respective to the feeding times that are added
     */
    public void addFeedingToSchedule() {
        for (FeedingSchedule feeding : feedings) {
            int feedingStartHour = feeding.getStartHour();
            int feedingMaxWindow = feeding.getTimeWindow();
            int currentWindow = 0;
            boolean taskAssigned = false;
            while (currentWindow < feedingMaxWindow) {
                int currentHour = feedingStartHour + currentWindow;
                if (schedule.get(currentHour).getTimeRemaining() >= feeding.getDuration()) {
                    schedule.get(currentHour).addTask(feeding.getDescription() + " " + feeding.getName());
                    int newTimeRemaining = schedule.get(currentHour).getTimeRemaining()
                            - feeding.getDuration();
                    schedule.get(currentHour).updateTimeRemaining(newTimeRemaining);
                    taskAssigned = true;
                    break;
                } else {
                    currentWindow++;
                }
            }
            if (!taskAssigned) {
                callBackupVolunteer(feeding);
            }
        }
    }

    /**
     * retrieves all the names (nicknames) of the animals currently at
     * the shelter, returns it as a String
     * 
     * @return String of all animal names
     */
    public String getAllNames() {
        StringBuilder sb = new StringBuilder();
        for (Treatment treatment : treatments) {
            if (!sb.toString().contains(treatment.getANIMAL().getNAME()))
                sb.append(treatment.getANIMAL().getNAME()).append("\n");
        }
        return sb.toString();
    }

    /**
     * String output for if a backup volunteer is needed depending on the feeding
     * times, when time exceeds the hour, then a backup volunteer is called.
     * 
     * @param feeding
     */
    public void callBackupVolunteer(FeedingSchedule feeding) {
        System.out.println("Not enough time for feeding: " + feeding.getName() + ". Calling backup volunteer.");
    }

    /**
     * adds the cage cleaning task to the schedule, and calculates the
     * corresponding time after the cleaning is done.
     */
    public void addCageCleaningToSchedule() {
        for (CleaningCage cageCleaning : cageCleanings) {
            int cageCleaningDuration = cageCleaning.getDuration();
            String cageCleaningDescription = cageCleaning.getDescription();

            for (int i = 0; i < 24; i++) {
                if (schedule.get(i).getTimeRemaining() >= cageCleaningDuration) {
                    schedule.get(i).addTask(cageCleaningDescription + " " + cageCleaning.getName());
                    int newTimeRemaining = schedule.get(i).getTimeRemaining() - cageCleaningDuration;
                    schedule.get(i).updateTimeRemaining(newTimeRemaining);
                    break;
                }
            }
        }
    }

    /**
     * adds animals to the ArrayList<Animal>, based on the type of species they are
     * 
     * @param animals
     */
    public void addAnimals(ArrayList<Animal> animals) {
        for (Animal animal : animals) {
            if (animal.getSPECIES().equals("porcupine")) {
                this.animalCount.put("porcupine", animalCount.get("porcupine") + 1);
            } else if (animal.getSPECIES().equals("coyote")) {
                this.animalCount.put("coyote", animalCount.get("coyote") + 1);
            } else if (animal.getSPECIES().equals("fox")) {
                this.animalCount.put("fox", animalCount.get("fox") + 1);
            } else if (animal.getSPECIES().equals("raccoon")) {
                this.animalCount.put("raccoon", animalCount.get("raccoon") + 1);
            } else if (animal.getSPECIES().equals("beaver")) {
                this.animalCount.put("beaver", animalCount.get("beaver") + 1);
            }
        }
    }

    /**
     * adds feeding tasks based on the FeedingSchedule object
     * 
     * @param feeding
     */
    public void addFeeding(FeedingSchedule feeding) {
        feedings.add(feeding);
    }

    /**
     * adds the cage cleaning tasks based on the CleaningCage object
     * 
     * @param cageCleaning
     */
    public void addCageCleaning(CleaningCage cageCleaning) {
        cageCleanings.add(cageCleaning);
    }

    /**
     * adds the treatment tasks based on the Treatment object
     * 
     * @param treatment
     */
    public void addTreatment(Treatment treatment) {
        treatments.add(treatment);
    }

    /**
     * a getter for recieving the treatments
     * 
     * @return ArrayList<Treatment> treatments
     */
    public ArrayList<Treatment> getTreatment() {
        return treatments;
    }

    /**
     * a getter for recieving the feeding tasks
     * 
     * @return ArrayList<FeedingSchedule> feedings
     */
    public ArrayList<FeedingSchedule> getFeeding() {
        return feedings;
    }

    /**
     * a getter for recieving the cage cleaning tasks
     * 
     * @return ArrayList<CleaningCage> cageCleanings
     */
    public ArrayList<CleaningCage> getCageCleaning() {
        return cageCleanings;
    }

    /**
     * a getter for recieving the number of animals
     * 
     * @return HashMap<String, Integer> animalCount
     */
    public HashMap<String, Integer> getAnimalCount() {
        return animalCount;
    }

    /**
     * a getter for recieving the final schedule
     * 
     * @return HashMap<Integer, ToDo> schedule
     */
    public HashMap<Integer, ToDo> getSchedule() {
        return schedule;
    }

    /**
     * prints the schedule to the made GUI in the Main class, with the
     * corresponding times (00:00 to 23:00), and the respective tasks associated
     * with the times
     * 
     * @return String representation of the schedule
     */
    public String printSchedule() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 24; i++) {
            sb.append(i).append(":00\n").append(schedule.get(i)).append("\n");
        }
        return sb.toString();
    }

    /**
     * outputs the final schedule to a .txt file for the user to retrieve
     * with the GUI implemented in the Main class
     */
    public void printScheduleToFile() {
        FileWriter out = null;
        String outName = "schedule.txt";

        try {
            out = new FileWriter(outName);
            out.write(printSchedule());
        } catch (IOException e) {
            System.out.println("Error writing to file " + outName);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    System.out.println("Error closing file " + outName);
                }
            }
        }
    }
}
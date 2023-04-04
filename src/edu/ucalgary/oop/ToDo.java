package edu.ucalgary.oop;

import java.util.*;
/**
 * The ToDo class is used for this project. It has a toDoList which is an array list
 * of type String and sets a constant to timeRemaining. This class sets the time
 * remaning for each task.
 * @author Group 4
 * @since 2023-03-23
 */
public class ToDo {
    private int timeRemaining = 60;
    private ArrayList<String> toDoList;
/**
   * Constructor for the ToDo class
   * 
   * @param timeRemaining
   * @param toDoList
   */
    public ToDo() {
        toDoList = new ArrayList<String>();
    }
/**
   * adds the task to the ArrayList of toDoList
   * 
   * @add task of animal to toDoList
   */
    public void addTask(String task) {
        toDoList.add(task);
    }
/**
   * returns the timeremaining of the task
   * 
   * @return timeRemaining of task
   */
    public int getTimeRemaining() {
        return timeRemaining;
    }
/**
   * updates the time remaining for the task
   * 
   * @set timeRemaining of animal
   */
    public void updateTimeRemaining(int time) {
        timeRemaining = time;
    }
/**
   * returns the task from the list of total tasks
   * 
   * @return task that needs to be completed
   */
    public String getTasks() {
        String tasks = "";
        for (String task : toDoList) {
            tasks += task + ", ";
        }
        return tasks;
    }
/**
   * returns a string of the task and the time remaining in that hour
   * 
   * @return formatted String of what was listed above
   *
   */
    @Override
    public String toString() {
        return "Task: " + getTasks() + "Time Remaining: " + timeRemaining;
    }

}
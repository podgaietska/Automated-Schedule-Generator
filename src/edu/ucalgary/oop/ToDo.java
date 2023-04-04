package edu.ucalgary.oop;

import java.util.*;

public class ToDo {
    private int timeRemaining = 60;
    private ArrayList<String> toDoList;

    public ToDo() {
        toDoList = new ArrayList<String>();
    }

    public void addTask(String task) {
        toDoList.add(task);
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }

    public void updateTimeRemaining(int time) {
        timeRemaining = time;
    }

    public String getTasks() {
        String tasks = "";
        for (String task : toDoList) {
            tasks += task + ", ";
        }
        return tasks;
    }

    @Override
    public String toString() {
        return "Task: " + getTasks() + "Time Remaining: " + timeRemaining;
    }

}

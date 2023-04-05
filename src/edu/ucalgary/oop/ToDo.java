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
        String output = "";
        if (!toDoList.isEmpty())
            for (String task: toDoList){
                output += task + '\n';
            }
        else 
            output = "No tasks to do" + '\n';
        return output;
        // String tasks = "";
        // for (String task : toDoList) {
        //     tasks += task + '\n';
        // }
        // return tasks;
    }

    @Override
    public String toString() {
        return getTasks();
    }

}
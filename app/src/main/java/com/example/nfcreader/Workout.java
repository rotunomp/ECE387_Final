package com.example.nfcreader;

public class Workout {
    private String machine;
    private int reps, weight;

    public Workout(String machine, int reps, int weight) {
        this.machine = machine;
        this.reps = reps;
        this.weight = weight;
    }

    public String getMachine() {
        return machine;
    }

    public int getReps() {
        return reps;
    }

    public int getWeight() {
        return weight;
    }
}

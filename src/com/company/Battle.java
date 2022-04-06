package com.company;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;

public class Battle implements Serializable {
    /*
    Als eerste krijgen we de Object attributen voor deze klasse.
     */

    private LocalTime beginTime;
    private LocalTime endTime;
    private int popularityPercent;
    private Arena arena;
    private Trainer trainer1;
    private Trainer trainer2;

    /*
    Als tweede krijgen we de constructor(s) voor deze klasse.
     */
    //TODO Add percentage availability check.
    public Battle(LocalTime beginTime, LocalTime endTime, int popularityPercent, Arena arena, Trainer trainer1, Trainer trainer2) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.popularityPercent = popularityPercent;
        this.arena = arena;
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;
        Battle.list.add(this);
    }

    /*
       Nu komen methods die public zijn en dus door andere Klassen bereikt kunnen worden.
     */

    public LocalTime getBeginTime() {
        return this.beginTime;
    }

    public LocalTime getEndTime() {
        return this.endTime;
    }

    public int getPopularity() {
        return this.popularityPercent;
    }

    public String getPopularityString() {
        String popularityString = String.valueOf(getPopularity());
        return popularityString;
    }

    public Arena getArena() {
        return this.arena;
    }

    public Trainer getTrainer1() {
        return this.trainer1;
    }

    public Trainer getTrainer2() {
        return this.trainer2;
    }

    public void setBeginTime(LocalTime beginTime) {
        this.beginTime = beginTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    //TODO Add Availablity check.
    public void setPopularity(int popularityPercent) {
        this.popularityPercent = popularityPercent;
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }

    public void setTrainer1(Trainer trainer1) {
        this.trainer1 = trainer1;
    }

    public void setTrainer2(Trainer trainer2) {
        this.trainer2 = trainer2;
    }

    public static ArrayList<Battle> list = new ArrayList<>();

    public void remove() {
        Battle.list.remove(this);
    }

    public int availablePopulationPercent() {
        int availablePopulation = 100;
        if (Battle.list.size() > 0) {
            for (Battle battle : Battle.list) {
                availablePopulation -= battle.getPopularity();
                if (availablePopulation < 0) {
                    int givingPopulation = battle.getPopularity() - (availablePopulation * -1);
                    availablePopulation = 0;
                    return givingPopulation;
                }
            }
        }
        return availablePopulation;
    }

    public boolean populationIsAvailable(int population) {
        if ((availablePopulationPercent() - population) >= 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Battle{" +
                "beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", popularity=" + popularityPercent +
                ", arena=" + arena +
                ", trainer1=" + trainer1 +
                ", trainer2=" + trainer2 +
                '}';
    }
}

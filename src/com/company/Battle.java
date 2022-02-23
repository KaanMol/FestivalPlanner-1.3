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
    private int popularity;
    private Arena arena;
    private Trainer trainer1;
    private Trainer trainer2;

    /*
    Als tweede krijgen we de constructor(s) voor deze klasse.
     */

    public Battle(LocalTime beginTime, LocalTime endTime, Arena arena, Trainer trainer1, Trainer trainer2) {
        this.beginTime = beginTime;
        this.endTime = endTime;
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
        return this.popularity;
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

//    public void setPopularity(int popularity) {
//        this.popularity = popularity;
//    }

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

    public void removeBattle(Battle battle) {
        Battle.list.remove(battle);
    }

    @Override
    public String toString() {
        return "Battle{" +
                "beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", popularity=" + popularity +
                ", arena=" + arena +
                ", trainer1=" + trainer1 +
                ", trainer2=" + trainer2 +
                '}';
    }
}

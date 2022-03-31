package com.company;

import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;

public class Schedule implements Serializable {

    private static ArrayList<Battle> battles = Battle.list;

    public Schedule() {
    }

    public boolean addBattle(LocalTime beginTime, LocalTime endTime, int popularityPercent, Arena arena, Trainer trainer1, Trainer trainer2) {
        boolean timeAvailable = true;
        for (Battle battle : battles) {
            if (battle.getArena() != arena) {
                continue;
            }
            if ((beginTime.isBefore(battle.getEndTime()) && endTime.isAfter(battle.getEndTime())) == false) {
                timeAvailable = false;
                break;
            }
        }
        if (timeAvailable == false) {
            return false;
        }
        battles.add(new Battle(beginTime, endTime, popularityPercent, arena, trainer1, trainer2));
        return true;
    }

    public void writeDataToFile(String filename) {
        try (PrintWriter printWriter = new PrintWriter(filename)) {
            for (Battle battle : battles)
                printWriter.println(battle.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void output() {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("ObjectTest"))) {
            output.writeObject(Battle.list);
            output.writeObject(Trainer.list);
            output.writeObject(Arena.list);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void input() {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("ObjectTest"))) {

            Battle.list = (ArrayList<Battle>) input.readObject();
            Trainer.list = (ArrayList<Trainer>) input.readObject();
            Arena.list = (ArrayList<Arena>) input.readObject();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        return "Schedule{" +
                battles +
                '}';
    }
}












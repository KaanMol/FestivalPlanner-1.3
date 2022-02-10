
import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;

public class Schedule {

    private ArrayList<Battle> battles = new ArrayList<>();

    public boolean addBattle(LocalTime beginTime, LocalTime endTime, Arena arena, Trainer trainer1, Trainer trainer2) {
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

        battles.add(new Battle(beginTime, endTime, arena, trainer1, trainer2));
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

    public static void main(String[] args) {
        Schedule schedule = new Schedule();
//        schedule.addBattle(LocalTime.of(1, 30), LocalTime.of(2, 30), new Arena("arena1")
//                , new Trainer("Owen", "Wouter"), new Trainer("Niels", "Koen"));
//        schedule.writeDataToFile("Kaan.txt");
        schedule.input();



    }


    public void output() {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Dirk"))) {
            output.writeObject(battles);
        } catch (Exception e) {

        }
    }

    public void input() {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("Dirk"))) {
            this.battles = (ArrayList<Battle>) input.readObject();

        } catch (Exception e) {

        }
    }
}












package com.company;

import java.io.File;
import java.time.LocalTime;

import com.company.infinity.Button;
import com.company.infinity.Infinity;
import com.company.infinity.Sound;
import com.company.infinity.Table;
import com.company.infinity.TableCell;
import com.company.infinity.Unit;
import com.company.popup.ArenaPopup;
import com.company.popup.BattlePopup;
import com.company.popup.CreateBattlePopup;
import com.company.popup.TrainerPopup;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableRow;
import javafx.stage.Stage;

public class Main extends Application {
    public Infinity infinity;

    public static void main(String[] args) {
        launch(Main.class);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("InfinityWindow");
        
        Infinity infinity = new Infinity(800, 600);
        Scene scene = new Scene(new Group(Infinity.instance));

        primaryStage.setScene(scene);
        primaryStage.show();
        
        double windowDelteWidth = primaryStage.getWidth() - scene.getWidth();
        double windowDeltaHeight = primaryStage.getHeight() - scene.getHeight();

        primaryStage.widthProperty().addListener((observable, oldValue, newValue) -> {
            infinity.setWidth(newValue.doubleValue() - windowDelteWidth);
        });

        primaryStage.heightProperty().addListener((observable, oldValue, newValue) -> {
            infinity.setHeight(newValue.doubleValue() - windowDeltaHeight);
        });
        
        infinity.start();

        Button create = new Button(0, 0, Unit.px(100), Unit.px(50), "Create");
        Button musicPlay = new Button(101, 0, Unit.px(100), Unit.px(50), "Play Music");
        Button musicPause = new Button(202, 0, Unit.px(100), Unit.px(50), "Pause Music");
        new Arena("School");
        new Arena("BattleArena 1");
        new Arena("BattleArena 2");

        new Trainer("Niels", "Dirk");
        new Trainer("Owen", "Kaan");

        new Battle(LocalTime.parse("10:00"), LocalTime.parse("12:00"), Arena.list.get(0), Trainer.list.get(0), Trainer.list.get(1));

        // Button create = new Button(0, 0, Unit.px(100), Unit.vh(50), "Create");
        // Button edit = new Button(101, 0, Unit.px(100), Unit.px(50), "Edit");
        // Button read = new Button(202, 0, Unit.vw(50), Unit.vh(50), "Read");

        Sound sound = new Sound("test.mp3");
        sound.player.setVolume(0.02);

        create.onMouseClick(e -> {
            System.out.println("Create triggered!");
            new CreateBattlePopup();
        });

        musicPlay.onMouseClick(e -> {
            System.out.println("Starting music");
            sound.player.play();
        });

        musicPause.onMouseClick(e -> {
            System.out.println("Music paused!");
            sound.player.pause();
        });

        int minHour = 9;
        int maxHour = 20;

        Table table = new Table(0, 51, Unit.vw(100), Unit.vh(100).subtract(Unit.px(50)));
        
        table.addColumn("");
        for (int arena = 0; arena < Arena.list.size(); arena++) {
            table.addColumn(Arena.list.get(arena).getArenaName());
        }

        table.addRow("");
        for (int i = minHour; i < maxHour; i++) {
            table.addRow(i + "");
        }

        // Battle battle = Battle.list.get(0);
        // int xMultiplier = battle.getEndTime().getHour() - battle.getBeginTime().getHour();
        // TableCell cell = new TableCell(battle.getTrainer1().getName() + " vs " + battle.getTrainer2().getName());
        
        // table.addCell(0, battle.getBeginTime().getHour() - minHour, xMultiplier, 0, cell);

    }
}

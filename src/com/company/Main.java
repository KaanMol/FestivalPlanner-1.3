package com.company;

import com.company.infinity.Button;
import com.company.infinity.Infinity;
import com.company.infinity.Table;
import com.company.infinity.Unit;
import com.company.popup.ArenaPopup;
import com.company.popup.BattlePopup;
import com.company.popup.TrainerPopup;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
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
        primaryStage.widthProperty().addListener((observable, oldValue, newValue) -> {
            infinity.setWidth(scene.getWidth());
        });
        primaryStage.heightProperty().addListener((observable, oldValue, newValue) -> {
            infinity.setHeight(scene.getHeight());
        });

        primaryStage.show();
        infinity.start();

        new Arena("School");
        new Trainer("Niels", "Dirk");
        new Trainer("Owen", "Kaan");
        new BattlePopup(null);

        // Button create = new Button(0, 0, Unit.px(100), Unit.vh(50), "Create");
        // Button edit = new Button(101, 0, Unit.px(100), Unit.px(50), "Edit");
        // Button read = new Button(202, 0, Unit.vw(50), Unit.vh(50), "Read");

        // create.onMouseClick(e -> {
        //     System.out.println("Button clicked!");
        //     System.out.println(e.getX());
        // });

//        Table table = new Table(0, 0, Unit.vw(100), Unit.vh(100));
//        table.addHeader("Lol");
//        table.addHeader("Lol");
//        table.addHeader("Lol");
//        table.addHeader("Lol");
//        table.addHeader("Lol");
//        table.addHeader("Lol");
//
//        table.addRow("Lol");
//        table.addRow("Lol");
//        table.addRow("Lol");
//        table.addRow("Lol");
//        table.addRow("Lol");
//        table.addRow("Lol");
//        table.addRow("Lol");
    }
}

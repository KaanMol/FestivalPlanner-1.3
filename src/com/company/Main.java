package com.company;

import com.company.infinity.Button;
import com.company.infinity.Infinity;
import com.company.infinity.Unit;
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

        Button create = new Button(0, 0, Unit.px(100), Unit.vh(50), "Create");
        Button edit = new Button(101, 0, Unit.px(100), Unit.px(50), "Edit");
        Button read = new Button(202, 0, Unit.vw(50), Unit.vh(50), "Read");

        create.onMouseClick(e -> {
            System.out.println("Button clicked!");
            System.out.println(e.getX());
        });
    }
}

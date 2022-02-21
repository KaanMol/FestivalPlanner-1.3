package com.company;

import java.util.ArrayList;
import com.company.infinity.Button;
import com.company.infinity.Infinity;
import com.company.infinity.Node;
import org.jfree.fx.FXGraphics2D;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Main extends Application {
    public Infinity infinity;

    public static void main(String[] args) {
        launch(Main.class);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World");
        
        Infinity infinity = new Infinity(800, 600);
        
        TabPane pane = new TabPane();
        Tab tab = new Tab("schedule");
        tab.setClosable(false);
        tab.setContent(new Group(Infinity.instance));
        pane.getTabs().add(tab);
        primaryStage.setScene(new Scene(pane));

        primaryStage.show();
        infinity.start();

        Button create = new Button(0, 0, 100, 50, "Create");
        Button edit = new Button(101, 0, 100, 50, "Edit");
        Button read = new Button(202, 0, 150, 50, "Read");

        create.onMouseClick(e -> {
            System.out.println("Button clicked!");
            System.out.println(e.getX());
        });
    }
}

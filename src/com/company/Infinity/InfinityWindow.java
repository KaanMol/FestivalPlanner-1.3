package com.company.Infinity;

import org.jfree.fx.FXGraphics2D;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InfinityWindow {
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World");
        Infinity2D infinity = new Infinity2D(800, 600);
        draw(new FXGraphics2D(infinity.getGraphicsContext2D()));
        primaryStage.setScene(new Scene(new Group(infinity)));
        primaryStage.show();
    }

    private void draw(FXGraphics2D fxGraphics2D) {
        
    }
}

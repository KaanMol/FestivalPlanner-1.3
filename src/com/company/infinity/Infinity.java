package com.company.infinity;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import org.jfree.fx.FXGraphics2D;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

public class Infinity extends Canvas {
    public static Infinity instance;

    public ArrayList<Node> nodes = new ArrayList<>();
    private int frameCount = 0;
    private int fps = 0;
    private LocalTime beginTime;
    public FXGraphics2D context;
    private AnimationTimer gameLoop = new AnimationTimer() {

        @Override
        public void handle(long now) {

            Infinity.instance.render();

            LocalTime currentTime = LocalTime.now();
            if (Infinity.instance.beginTime.until(LocalTime.now(), ChronoUnit.SECONDS) >= 1) {
                Infinity.instance.fps = Infinity.instance.frameCount;
                
                System.out.println("FPS: " + Infinity.instance.fps);

                Infinity.instance.frameCount = 0;
                Infinity.instance.beginTime = currentTime;
            }
            
            Infinity.instance.frameCount++;
        }
    };

    public Infinity(int width, int height) {
        this.setWidth(width);
        this.setHeight(height);
        Infinity.instance = this;
        this.context = new FXGraphics2D(this.getGraphicsContext2D());

        this.setOnMouseMoved(this::eventHandler);
        this.setOnMouseClicked(this::eventHandler);

        this.widthProperty().addListener((observable, oldValue, newValue) -> {
            this.setWidth(newValue.doubleValue());
        });

        this.heightProperty().addListener((observable, oldValue, newValue) -> {
            this.setHeight(newValue.doubleValue());
        });
    }

    private void eventHandler(MouseEvent event) {
        for (Node node : this.nodes) {
            if ((event.getX() > node.x && event.getX() < node.x + node.width) && (event.getY() > node.y && event.getY() < node.y + node.height)) {
                if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
                    node.callback.accept(event);
                }

                //todo fix me
                node.hover = true;
                this.getScene().setCursor(javafx.scene.Cursor.HAND);
                break;
            } else {
                node.hover = false;
                this.getScene().setCursor(javafx.scene.Cursor.DEFAULT);
            }
        }
    }
    
    public void render() {
        for (Node node : this.nodes) {
            node.draw();
        }
    }

    public void stop() {
        this.gameLoop.stop();
    }

    public void start() {
        this.beginTime = LocalTime.now();
        this.gameLoop.start();
    }
}

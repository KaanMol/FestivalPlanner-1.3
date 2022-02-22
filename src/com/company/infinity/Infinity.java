package com.company.infinity;

import java.awt.Color;

import org.jfree.fx.FXGraphics2D;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;

public class Infinity extends Canvas {
    public static Infinity instance;

    public NodeList nodeList = new NodeList();
    public Mouse mouse = new Mouse();
    public FXGraphics2D context;
    private FPS fps = new FPS();

    private AnimationTimer gameLoop = new AnimationTimer() {
        @Override
        public void handle(long now) {
            Infinity.instance.update();
            Infinity.instance.render();
        }
    };

    public Infinity(int width, int height) {
        this.setWidth(width);
        this.setHeight(height);

        Infinity.instance = this;

        this.context = new FXGraphics2D(this.getGraphicsContext2D());

        this.setOnMouseExited(this.mouse::update);
        this.setOnMouseMoved(this.mouse::update);
        this.setOnMouseClicked(this.mouse::update);
        
        this.fps.setZIndex(1);
        this.nodeList.add(this.fps);
    }
    
    public void update() {
        this.context.setColor(Color.WHITE);
        this.context.fillRect(0, 0, (int)this.getWidth(), (int)this.getHeight());

        boolean isHovering = false;

        for (Node node : this.nodeList.nodes) {
            node.update();
            
            if (node.inBounds(this.mouse.getX(), this.mouse.getY())) {
                node.hover = true;
                isHovering = true;

                if (this.mouse.getClicked()) {
                    this.mouse.setClicked(false);
                    node.callback.accept(this.mouse);
                }
            } else {
                node.hover = false;
            }
        }

        if (isHovering == true) {
            this.getScene().setCursor(javafx.scene.Cursor.HAND);
        } else {
            this.getScene().setCursor(javafx.scene.Cursor.DEFAULT);
        }
    }

    public void render() {
        for (Node node : this.nodeList.nodes) {
            node.draw();
        }
    }

    public void stop() {
        this.gameLoop.stop();
    }

    public void start() {
        this.fps.start();
        this.gameLoop.start();
    }
}

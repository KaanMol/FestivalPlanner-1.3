package com.company.infinity;

import java.awt.Color;
import org.jfree.fx.FXGraphics2D;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;

/**
 * Infinity is the main class of the Infinity game engine.
 * This class is responsible for initializing the game engine and starting the game loop.
 */
public class Infinity extends Canvas {
    public static Infinity instance;
    public NodeList nodeList = new NodeList();
    public Mouse mouse = new Mouse();
    public FXGraphics2D context;
    private FPS fps = new FPS();

    /**
     * The main gameloop of the Infinity game engine.
     * This creates an Animation Timer that is V-Synced with the screen.
     * 
     */
    private AnimationTimer gameLoop = new AnimationTimer() {
        @Override
        public void handle(long now) {
            Infinity.instance.update();
            Infinity.instance.render();
        }
    };

    /**
     * Initializes the Infinity game engine.
     * @param width
     * @param height
     */
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

    /**
     * Adds a node to the Infinity game engine.
     */
    public void addNode(Node node) {
        this.nodeList.add(node);
    }
    
    /**
     * Update method that calls every other update method.
     */
    public void update() {
        // Cleans the canvas every update
        this.context.setColor(Color.WHITE);
        this.context.fillRect(0, 0, (int)this.getWidth(), (int)this.getHeight());

        boolean isHovering = false;
        Node clickedNode = null;
        
        for (Node node : this.nodeList.getNodes()) {
            node.update();
            
            if (node.inBounds(this.mouse.getX(), this.mouse.getY()) && node.hasHover() == true) {
                node.hover = true;
                isHovering = true;

                if (this.mouse.getClicked()) {
                    if (clickedNode == null || clickedNode.getZIndex() < node.getZIndex()) {
                        clickedNode = node;
                    }
                    this.mouse.setClicked(false);
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
        
        if (clickedNode != null) {
            clickedNode.callback.accept(this.mouse);
        }
    }

    /**
     * Render method that calls every other render method.
     */
    public void render() {
        for (Node node : this.nodeList.getNodes()) {
            node.draw();
        }
    }

    /**
     * Stops the infinity game engine.
     */
    public void stop() {
        this.gameLoop.stop();
    }

    /**
     * Starts the infinity game engine.
     */
    public void start() {
        this.fps.start();
        this.gameLoop.start();
    }
}

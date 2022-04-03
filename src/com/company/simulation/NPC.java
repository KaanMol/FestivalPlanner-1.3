package com.company.simulation;

import com.company.infinity.Infinity;
import com.company.infinity.Node;
import org.jfree.fx.FXGraphics2D;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.*;

public abstract class NPC extends Node {
    private FXGraphics2D context;
    private boolean isSpawned;
    private Point2D position;
    private double speed;
    private int frame;
    protected List<BufferedImage> sprites;
    protected Map<Direction, List<BufferedImage>> animation;
    protected Direction direction;

    public NPC(Direction direction) {
        this.isSpawned = false;
        this.speed = 2;
        this.frame = 0;
        this.setZIndex(4);
        this.context = Infinity.instance.context;
        Infinity.instance.nodeList.add(this);
        this.direction = direction;
        loadImages();
    }

    public void update() {
        if (isSpawned) {
            setPosition(new Point2D.Double(
                    this.position.getX() + this.speed * direction.getX(),
                    this.position.getY() + this.speed * direction.getY()));
        }
    }

    public void draw() {
        if (isSpawned) {
            AffineTransform tx = new AffineTransform();
            tx.translate(position.getX(), position.getY());
            if (this.frame > this.animation.get(direction).size() - 1)
                this.frame = 0;
            context.drawImage(this.animation.get(direction).get(frame), tx, null);
            this.frame++;
        }
    }

    public abstract void loadImages();

    public abstract void setAnimationImages();

    public void spawn(Point2D spawnPosition) {
        if (!isSpawned) {
            this.position = spawnPosition;
            isSpawned = true;
        }
    }

    public void setPosition(Point2D newPosition) {
        this.position = newPosition;
    }

    public void setDirection(Direction newDirection) {
        this.direction = newDirection;
    }

//    public Direction getDirection() {
//        return this.direction;
//    }
}

package com.company.simulation;

import com.company.infinity.Infinity;
import com.company.infinity.Node;
import com.company.simulation.map.MapArea;
import com.company.simulation.map.TileMap;
import com.company.simulation.navigation.Direction;
import com.company.simulation.navigation.DistanceField;
import org.jfree.fx.FXGraphics2D;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;

public abstract class NPC extends Node {
    private FXGraphics2D context;
    protected List<BufferedImage> sprites;
    protected Map<Direction, List<BufferedImage>> animation;
    private Point2D position;
    protected Direction direction;
    protected Direction oldDirection;
    private DistanceField distanceField;
    protected TileMap tileMap;
    protected MapArea target;
    private boolean isSpawned;
    private double speed;
    private int frame;
    protected int centerX;
    protected int centerY;

    public NPC(TileMap tileMap) {
        this.tileMap = tileMap;
        this.isSpawned = false;
        this.speed = 2;
        this.frame = 0;
        this.setZIndex(4);
        this.context = Infinity.instance.context;
        this.direction = Direction.STATIC;
        this.oldDirection = Direction.EAST;
        loadImages();
    }

    public void update() {
        if (isSpawned) {
            if (direction != Direction.STATIC) {
                    this.oldDirection = direction;
                }
            setDirection(distanceField.getOptimalDirection((int) position.getX(), (int) position.getY()));
            setPosition(new Point2D.Double(
                    this.position.getX() + this.speed * direction.getX(),
                    this.position.getY() + this.speed * direction.getY()));
        }
    }

    public void draw(AffineTransform transform) {
        if (isSpawned) {
            AffineTransform tx = new AffineTransform(transform);
            tx.translate(position.getX() - centerX, position.getY()- centerY);
            System.out.println(animation);

            if (this.direction.equals(Direction.STATIC)) {
                context.drawImage(this.animation.get(oldDirection).get(0), tx, null);
            } else {
                if (this.frame > this.animation.get(direction).size() - 1)
                    this.frame = 0;
                context.drawImage(this.animation.get(direction).get(frame), tx, null);
                this.frame++;
            }
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

    public void setTarget(MapArea newTarget) {
        this.target = newTarget;
        this.distanceField = tileMap.getNavigation().getField(newTarget);
    }

//    public Direction getDirection() {
//        return this.direction;
//    }
}

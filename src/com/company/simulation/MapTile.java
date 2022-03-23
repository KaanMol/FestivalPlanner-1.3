package com.company.simulation;

import com.company.infinity.Node;

import java.awt.*;
import java.awt.geom.Point2D;

public class MapTile extends Node {
    private Point2D position;
    private Image image;

    public MapTile(Point2D position, Image image) {
        if (image != null) {
            this.image = image;
        }
        this.position = position;
    }

    public Point2D getPosition() {
        return position;
    }

    // TODO visualise tiles *somehow*

    @Override
    public void draw() {
        super.draw();
    }

    @Override
    public void update() {
        super.update();
    }
}

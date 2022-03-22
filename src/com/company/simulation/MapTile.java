package com.company.simulation;

import java.awt.*;
import java.awt.geom.Point2D;

public class MapTile {
    private Point2D position;
    private Image image;

    public MapTile(Point2D position, Image image) {
        this.image = image;
        this.position = position;
    }

    public Point2D getPosition() {
        return position;
    }

    // TODO visualise tiles *somehow*
}

package com.company.simulation;

import java.awt.geom.Point2D;

public enum Direction {
    NORTH(0, -1),
    EAST(1, 0),
    SOUTH(0, 1),
    WEST(-1, 0);

    private final Point2D direction;
    private int x;
    private int y;

    Direction(int x, int y) {
        this.direction = new Point2D.Double(x, y);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point2D getDirection() {
        return direction;
    }
}

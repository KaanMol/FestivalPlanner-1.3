package com.company.simulation.navigation;

import java.awt.geom.Point2D;

public enum Direction {
    STATIC(0, 0),
    WEST(-1, 0),
    EAST(1, 0),
    NORTH(0, -1),
    SOUTH(0, 1);

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

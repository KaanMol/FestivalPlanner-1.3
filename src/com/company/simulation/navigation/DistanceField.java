package com.company.simulation.navigation;

import com.company.simulation.map.MapArea;
import com.company.simulation.map.TileMap;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceField {
    private int[][] distances;
    private TileMap map;
    private MapArea area;

    public DistanceField(MapArea area, TileMap map) {
        this.map = map;
        this.area = area;

        distances = new int[map.getHeight()][map.getWidth()];
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                distances[i][j] = Integer.MAX_VALUE;
            }
        }

        generateField();
    }

    private void generateField() {
        Queue<Point> queue = new LinkedList<>();

        int minX = (int) area.getBounds().getMinX() / 16;
        int minY = (int) area.getBounds().getMinY() / 16;
        int maxX = 1 + (int) area.getBounds().getMaxX() / 16;
        int maxY = 1 + (int) area.getBounds().getMaxY() / 16;

        for (int y = minY; y < maxY; y++) {
            for (int x = minX; x < maxX; x++) {
                if (map.isPassable(x, y)) {
                    queue.add(new Point(x, y));
                    distances[y][x] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (Direction direction : Direction.values()) {
                int x = (int) p.getX() + direction.getX();
                int y = (int) p.getY() + direction.getY();
                if (x < 0 || x >= map.getWidth()
                        || y < 0 || y >= map.getHeight()
                        || !map.isPassable(x, y) || distances[y][x] != Integer.MAX_VALUE) {
                    continue;
                }

                queue.add(new Point(x, y));
                distances[y][x] = distances[(int) p.getY()][(int) p.getX()] + 1;
            }
        }
    }

    public Direction getOptimalDirection(int x, int y) {
        int convertedX = x / 16;
        int convertedY = y / 16;

        int minValue = Integer.MAX_VALUE;
        Direction optimalDir = Direction.STATIC;

        for (Direction direction : Direction.values()) {
            int newX = convertedX + direction.getX();
            int newY = convertedY + direction.getY();
            if (newX < 0 || newX >= map.getWidth()
                    || newY < 0 || newY >= map.getHeight()) {
                continue;
            }

            if (distances[newY][newX] < minValue) {
                optimalDir = direction;
                minValue = distances[newY][newX];
            }
        }

        return optimalDir;
    }
}

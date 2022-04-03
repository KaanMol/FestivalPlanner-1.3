package com.company.simulation.navigation;

import com.company.simulation.map.MapArea;
import com.company.simulation.map.TileMap;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceField {
    private int[][] distances;

    public DistanceField(MapArea area, TileMap map) {
        distances = new int[map.getHeight()][map.getWidth()];
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                distances[i][j] = Integer.MAX_VALUE;
            }
        }

        generateField(area, map);
    }

    private void generateField(MapArea area, TileMap map) {
        Queue<Point> queue = new LinkedList<>();

        int minX = (int) area.getBounds().getMinX() / 16;
        int minY = (int) area.getBounds().getMinY() / 16;
        int maxX = 1 + (int) area.getBounds().getMaxX() / 16;
        int maxY = 1 + (int) area.getBounds().getMaxY() / 16;

        for (int y = minY; y < maxY; y++) {
            for (int x = minX; x < maxX; x++) {
                if (map.isPassable(x, y)) {
                    queue.add(new Point(x, y));
                }
            }
        }

        for (Point point : queue) {
            System.out.println(point);
        }
    }
}

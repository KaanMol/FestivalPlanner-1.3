package com.company.simulation;

import com.company.infinity.Node;
import com.company.infinity.Unit;
import com.company.simulation.map.MapLayer;
import com.company.simulation.map.MapTile;
import com.company.simulation.map.TileMap;

import java.awt.geom.AffineTransform;
import java.util.LinkedList;
import java.util.List;

public class SimulationView extends Node {
    private TileMap map;
    private List<NPC> npcs = new LinkedList<>();

    private AffineTransform viewTransform = new AffineTransform();

    public SimulationView(TileMap map) {
        this.map = map;

        width = Unit.px(map.getWidth() * 16);
        height = Unit.px(map.getHeight() * 16);
    }

    public TileMap getMap() {
        return map;
    }

    public List<NPC> getNpcs() {
        return npcs;
    }

    @Override
    public void draw() {
        for (MapLayer layer : map.getLayers()) {
            for (int y = 0; y < map.getHeight(); y++) {
                for (int x = 0; x < map.getWidth(); x++) {
                    try {
                        MapTile tile = layer.getTile(x, y);
                        tile.draw(viewTransform);
                    } catch (Exception ex) {
                        // nothing to render
                    }
                }
            }
        }

        for (NPC npc : npcs) {
            npc.draw(viewTransform);
        }
    }

    @Override
    public void update() {
        double mapWidth = map.getWidth() * 16;
        double mapHeight = map.getHeight() * 16;
        viewTransform = new AffineTransform(width.getValue() / mapWidth, 0, 0, height.getValue()/mapHeight, x, y);

        for (MapLayer layer : map.getLayers()) {
            for (int y = 0; y < map.getHeight(); y++) {
                for (int x = 0; x < map.getWidth(); x++) {
                    try {
                        MapTile tile = layer.getTile(x, y);
                        tile.update();
                    } catch (Exception ex) {
                        // nothing to update
                    }
                }
            }
        }

        for (NPC npc : npcs) {
            npc.update();
        }
    }
}

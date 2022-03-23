package com.company.simulation;

public class MapLayer {
    private MapTile[][] tiles;
    private int zIndex;

    public MapLayer(int zIndex) {
        this.zIndex = zIndex;
    }

    public void setTile(MapTile tile, int x, int y) {
        tiles[y][x] = tile;
    }

    public MapTile getTile(int x, int y) {
        return tiles[y][x];
    }
}

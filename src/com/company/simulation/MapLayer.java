package com.company.simulation;

public class MapLayer {
    private MapTile[][] tiles;
    private int zIndex;

    public MapLayer(int width, int height, int zIndex) {
        tiles = new MapTile[height][width];
        this.zIndex = zIndex;
    }

    public void setTile(MapTile tile, int x, int y) {
        tiles[y][x] = tile;
        tile.setZIndex(zIndex);
    }

    public MapTile getTile(int x, int y) {
        return tiles[y][x];
    }
}

package com.company.simulation.map;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

public class TileMap {
    private List<MapLayer> layers = new ArrayList<>();
    private List<MapArea> areas = new ArrayList<>();
    private List<Image> sprites = new ArrayList<>();

    private int width;
    private int height;

    public TileMap() {
        this(new File(System.getProperty("user.dir") + "/assets/tilemaps/default.json"));
    }

    public TileMap(File file) {
        generateSprites();

        StringBuilder json = new StringBuilder();
        try {
            Scanner s = new Scanner(file);
            while (s.hasNextLine()) {
                json.append(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        JsonReader reader = Json.createReader(new StringReader(json.toString()));

        JsonObject object = reader.readObject();

        width = object.getInt("width");
        height = object.getInt("height");
        JsonArray jsonLayers = object.getJsonArray("layers");
        for (JsonValue jsonLayer : jsonLayers) {
            addLayer(jsonLayer.asJsonObject());
        }
    }

    public boolean isPassable(int x, int y) {
        //NOTE: boldly assumes last layer is collision-related
        return layers.get(layers.size() - 1).getTile(x, y) != null;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<MapArea> getAreas() {
        return areas;
    }

    private void addLayer(JsonObject layer) {
        if (layer.getString("type").equals("tilelayer")) {
            boolean visible = layer.getBoolean("visible");
            MapLayer mapLayer = new MapLayer(width, height, layers.size() + 2);
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int type = layer.getJsonArray("data").getInt(x + y * width) - 1;
                    if (type != -1) {
                        MapTile tile = new MapTile(new Point2D.Double(x * 16, y * 16), sprites.get(type));
                        tile.setRenderable(visible);
                        mapLayer.setTile(tile, x, y);
                    }
                }
            }
            layers.add(mapLayer);
        } else {
            //TODO: handle object layer
        }
    }

    private void generateSprites() {
        try {
            BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir") + "/assets/images/tileset.png"));
            int w = 16;
            int h = 16;
            for (int y = 0; y < image.getHeight() / h; y++) {
                for (int x = 0; x < image.getWidth() / w; x++) {
                    this.sprites.add(image.getSubimage(x * w, y * h, w, h));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

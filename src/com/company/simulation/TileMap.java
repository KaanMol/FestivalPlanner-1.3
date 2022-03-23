package com.company.simulation;

import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

public class TileMap {
    private ArrayList<MapLayer> layers = new ArrayList<>();
    private ArrayList<MapArea> areas = new ArrayList<>();

    private int width;
    private int height;

    public TileMap(File file) {
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

        width = reader.readObject().getInt("width");
        height = reader.readObject().getInt("height");
        JsonArray jsonLayers = reader.readObject().getJsonArray("layers");
        for (JsonValue jsonLayer : jsonLayers) {
            addLayer(jsonLayer.asJsonObject());
        }
    }

    public boolean isPassable(int x, int y) {
        //NOTE: boldly assumes last layer is collision-related
        return layers.get(layers.size() - 1).getTile(x, y) != null;
    }

    private void addLayer(JsonObject layer) {
        if (layer.getString("type").equals("tilelayer")) {
            MapLayer mapLayer = new MapLayer(layers.size());
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int type = layer.getJsonArray("data").getInt(x + y * width) - 1;
                    if (type != -1){
                        mapLayer.setTile(new MapTile(new Point2D.Double(x * 16, y * 16), null), x, y);
                    }
                }
            }
            layers.add(mapLayer);
        } else {
            //TODO: handle object layer
        }
    }
}

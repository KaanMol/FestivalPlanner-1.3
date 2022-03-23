package com.company.simulation;

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
        // TODO read json
    }
}

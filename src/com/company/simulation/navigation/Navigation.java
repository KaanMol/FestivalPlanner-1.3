package com.company.simulation.navigation;

import com.company.simulation.map.MapArea;
import com.company.simulation.map.TileMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Navigation {
    private Map<MapArea, DistanceField> distanceFields = new HashMap<>();

    public Navigation(TileMap map) {
        for (MapArea area : map.getAreas()) {
            distanceFields.put(area, new DistanceField(area, map));
        }
    }

    public DistanceField getField(MapArea area) {
        return distanceFields.get(area);
    }
}

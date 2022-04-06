package com.company.simulation.map;

import java.awt.*;

public class MapArea {
    private Rectangle area;
    private String name;
    private String type;

    public MapArea(Rectangle area, String name, String type) {
        this.area = area;
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Rectangle getBounds() {
        return area;
    }
}

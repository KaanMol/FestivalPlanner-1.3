package com.company.simulation.map;

import java.awt.*;

public class MapArea {
    private Rectangle area;

    public MapArea(Rectangle area) {
        this.area = area;
    }

    public Rectangle getBounds() {
        return area;
    }
}

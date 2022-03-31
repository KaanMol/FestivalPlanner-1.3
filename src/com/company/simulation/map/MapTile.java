package com.company.simulation.map;

import com.company.infinity.Infinity;
import com.company.infinity.Node;
import com.company.infinity.Unit;
import org.jfree.fx.FXGraphics2D;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

public class MapTile extends Node {
    private Point2D position;
    private Image image;
    private boolean isRenderable;
    private FXGraphics2D context;

    public MapTile(Point2D position, Image image) {
        if (image != null) {
            this.image = image;
        }
        this.position = position;

        this.context = Infinity.instance.context;
        Infinity.instance.nodeList.add(this);

        this.x = (int)position.getX();
        this.y = (int)position.getY();
        this.width = Unit.px(16);
        this.height = Unit.px(16);
    }

    public void setRenderable(boolean isRenderable) {
        this.isRenderable = isRenderable;
    }

    public Point2D getPosition() {
        return position;
    }

    @Override
    public void draw() {
        if (!isRenderable)
            return;
        context.drawImage(image, new AffineTransform(1, 0, 0, 1, this.x, this.y), null);
        //context.fillRect(this.x, this.y, this.width.getValue(), this.height.getValue());
    }

    @Override
    public void update() {
        // TODO when camera is implemented
    }
}

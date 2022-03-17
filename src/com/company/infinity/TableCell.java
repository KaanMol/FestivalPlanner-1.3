package com.company.infinity;

import java.awt.Color;

import org.jfree.fx.FXGraphics2D;
public class TableCell extends Node {
    public TableCell (String text) {
        this.text = text;
        
        Infinity.instance.nodeList.add(this);
    }

    @Override
    public void draw() {
        FXGraphics2D context = Infinity.instance.context;

        int columnWidth = this.width.getValue();
        int rowHeight = this.height.getValue();

        context.setColor(Color.LIGHT_GRAY);
        context.fillRect(0, 0, 500, 500);

        // context.setColor(Color.BLACK);
        // context.drawRect(this.x, this.y, columnWidth, rowHeight);
    }
}

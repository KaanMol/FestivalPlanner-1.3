package com.company.infinity;

import java.awt.Color;
import org.jfree.fx.FXGraphics2D;

/**
 * TableCell component
 */
public class TableCell extends Node {
    public String parent = "global";
    public float xMultiplier = 1;
    public float yMultiplier = 1;
    public int xIndex = 0;
    public int yIndex = 0;

    /**
     * Initializes table cell
     * @param text text for the inside of the cell
     */
    public TableCell (String text) {
        this.text = text;
        this.setZIndex(10);
    }

    /**
     * Draw the table cell
     */
    @Override
    public void draw() {
        FXGraphics2D context = Infinity.instance.context;

        int columnWidth = this.width.getValue();
        int rowHeight = this.height.getValue();
        
        context.setColor(Color.YELLOW);
        context.fillRect(this.x, this.y, this.width.getValue(), this.height.getValue());

        context.setColor(Color.BLACK);
        context.drawString(this.text, this.x + columnWidth / 2 - context.getFontMetrics().stringWidth(this.text) / 2, this.y + rowHeight / 2 + context.getFontMetrics().getHeight() / 2);
    }
}

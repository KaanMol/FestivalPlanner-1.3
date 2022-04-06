package com.company.infinity;

/**
 * Tab component
 */
public class Text extends Node {
    /**
     * Initializes the text
     * @param text text for the entity
     * @param x x coordinate of the left top corner of the text
     * @param y y coordinate of the left top corner of the text
     */
    public Text(String text, int x, int y) {
        this.text = text;
        this.x = x;
        this.y = y;
    }

    /**
     * Draws the text on the screen every cycle.
     */
    public void draw() {
        Infinity.instance.context.setColor(this.color);
        Infinity.instance.context.drawString(this.text, this.x, this.y);
    }
}

package com.company.infinity;

import java.awt.Color;
import java.util.function.Consumer;


public abstract class Node {
    public int x = 0;
    public int y = 0;
    public Unit width = Unit.px(0);
    public Unit height = Unit.px(0);
    public String text = "Button";
    public Color color = Color.BLACK;
    public Color textColor = Color.WHITE;
    public Color hoverColor = Color.GRAY;
    public boolean hover = false;
    public int zIndex = 0;
    public Consumer<Mouse> callback = e -> {};
    public String parent = "global";

    public int getZIndex() {
        return this.zIndex;
    }

    public int setZIndex(int zIndex) {
        return this.zIndex = zIndex;
    }

    public void draw() {}

    public void update() {}

    // public void hover(MouseEvent event) {
    //     boolean inHorizontal = (event.getX() > this.x && event.getX() < this.x + this.width.getValue());
    //     boolean inVertical = (event.getY() > this.y && event.getY() < this.y + this.height.getValue());
    //     if (inHorizontal && inVertical) {
    //         this.hover = true;
    //     } else {
    //         this.hover = false;
    //     }
    // }

    public void onMouseClick(Consumer<Mouse> callback) {
        this.callback = callback;
    }

    public boolean inBounds(int x, int y) {
        boolean inHorizontal = x > this.x && x < this.x + this.width.getValue();
        boolean inVertical = y > this.y && y < this.y + this.height.getValue();
        
        return (inHorizontal && inVertical);
    }
}

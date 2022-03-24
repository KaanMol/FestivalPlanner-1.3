package com.company.infinity;

import java.awt.Color;
import java.util.function.Consumer;


public abstract class Node {
    public int x = 0;
    public int y = 0;
    public Unit width = Unit.px(0);
    public Unit height = Unit.px(0);
    public boolean hover = false;
    protected boolean hasHover = false;
    public Consumer<Mouse> callback = e -> {};
    public int zIndex = 0;

    // TODO: Move this to a component
    public String text = "Button";
    public Color color = Color.BLACK;
    public Color textColor = Color.WHITE;
    public Color hoverColor = Color.GRAY;
    
    /**
     * 
     * @return the Z-index of this node
     */
    public int getZIndex() {
        return this.zIndex;
    }

    public int setZIndex(int zIndex) {
        return this.zIndex = zIndex;
    }

    public boolean hasHover() {
        return this.hasHover;
    }

    public void draw() {}

    public void update() {}

    public void onMouseClick(Consumer<Mouse> callback) {
        this.hasHover = true;
        this.callback = callback;
    }

    public boolean inBounds(int x, int y) {
        boolean inHorizontal = x > this.x && x < this.x + this.width.getValue();
        boolean inVertical = y > this.y && y < this.y + this.height.getValue();
        
        return (inHorizontal && inVertical);
    }
}

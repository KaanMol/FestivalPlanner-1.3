package com.company.infinity;

public class Text extends Node {
    public Text(String text, int x, int y) {
        this.text = text;
        this.x = x;
        this.y = y;
    }

    public void draw() {
        Infinity.instance.context.setColor(this.color);
        Infinity.instance.context.drawString(this.text, this.x, this.y);
    }
}

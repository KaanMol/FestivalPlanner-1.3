package com.company.infinity;
import java.awt.FontMetrics;

public class Button extends Node {
    public Button(int x, int y, Unit width, Unit height, String text) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;

        Infinity.instance.nodes.add(this);
    }

    @Override
    public void draw() {
        FontMetrics font = Infinity.instance.context.getFontMetrics();

        int fontWidth = font.stringWidth(text);
        int fontHeight = font.getHeight();

        if (this.hover) {
            Infinity.instance.context.setColor(this.hoverColor);
        } else {
            Infinity.instance.context.setColor(this.color);
        }

        Infinity.instance.context.fillRect(this.x, this.y, this.width.getValue(), this.height.getValue());
        
        Infinity.instance.context.setColor(this.textColor);
        Infinity.instance.context.drawString(this.text, this.x + ((this.width.getValue() - fontWidth) / 2), this.y + ((this.height.getValue() + fontHeight) / 2));
    }
}

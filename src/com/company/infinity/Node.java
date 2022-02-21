package com.company.infinity;

import java.awt.Color;
import java.util.function.Consumer;
import javafx.scene.input.MouseEvent;


public abstract class Node {
    public int x = 0;
    public int y = 0;
    public int width = 0;
    public int height = 0;
    public String text = "Button";
    public Color color = Color.BLACK;
    public Color textColor = Color.WHITE;
    public Color hoverColor = Color.GRAY;
    public boolean hover = false;
    public int zIndex = 0;
    public Consumer<MouseEvent> callback = e -> {};

    public void draw() {

    }

    public void onMouseClick(Consumer<MouseEvent> callback) {
        this.callback = callback;
    }
}

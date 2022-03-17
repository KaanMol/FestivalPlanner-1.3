package com.company.infinity;

import javafx.scene.input.MouseEvent;

public class Mouse {
    private int x;
    private int y;
    private boolean clicked;

    public Mouse() {
        this.x = 0;
        this.y = 0;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean getClicked() {
        return this.clicked;
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public void update(MouseEvent event) {
        this.setCoordinates((int)event.getX(), (int)event.getY());
        this.setClicked(event.getEventType() == MouseEvent.MOUSE_CLICKED);
    }
}

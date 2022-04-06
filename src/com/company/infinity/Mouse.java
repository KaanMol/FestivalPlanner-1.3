package com.company.infinity;

import javafx.scene.input.MouseEvent;

/**
 * Mouse interaction handler
 */
public class Mouse {
    // x location of the mouse
    private int x;
    // y location of the mouse
    private int y;
    // indicates if the mouse button is pressed
    private boolean clicked;

    /**
     * Initiate mouse
     */
    public Mouse() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Getter for the x coordinate of the mouse
     * @return int x coordinate of the mouse
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getter for the y coordinate of the mouse
     * @return int y coordinate of the mouse
     */
    public int getY() {
        return this.y;
    }

    /**
     * Getter for the clicked state of the mouse
     * @return boolean indicates if the mouse button is pressed
     */
    public boolean getClicked() {
        return this.clicked;
    }

    /**
     * Setter for the x coordinate of the mouse
     * @param x int x coordinate of the mouse
     */
    private void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Setter for the clicked state of the mouse
     * @param clicked boolean indicates if the mouse button is pressed
     */
    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    /**
     * Update method that updates the mouse coordinates
     * @param MouseEvent event
     */
    public void update(MouseEvent event) {
        this.setCoordinates((int)event.getX(), (int)event.getY());
        this.setClicked(event.getEventType() == MouseEvent.MOUSE_CLICKED);
    }
}

package com.company.infinity;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import java.awt.Color;

/**
 * FPS component.
 * This renders the FPS component in the top left corner. 
 */
public class FPS extends Node {
    private int frameCount = 0;
    private int fps = 0;
    private LocalTime beginTime;

    /**
     * Getter for the current FPS
     * @return the current FPS
     */
    public int getFPS() {
        return this.fps;
    }

    /**
     * Starts the FPS counter
     */
    public void start() {
        this.beginTime = LocalTime.now();
        this.frameCount = 0;
        this.fps = 0;
    }

    /**
     * Updates the FPS counter
     */
    @Override
    public void update() {
        this.frameCount++;
        
        LocalTime currentTime = LocalTime.now();

        if (this.beginTime.until(currentTime, ChronoUnit.SECONDS) >= 1) {
            this.fps = this.frameCount;

            this.frameCount = 0;
            this.beginTime = currentTime;
        }
    }

    /**
     * Renders the FPS counter
     */
    @Override
    public void draw() {
        Infinity.instance.context.setColor(Color.GREEN);
        Infinity.instance.context.drawString("FPS: " + this.fps, 10, 20);
    }
}

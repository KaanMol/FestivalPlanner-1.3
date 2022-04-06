package com.company.infinity;

/**
 * Unit class
 * Used for dynamic measurements
 */
public class Unit {
    private static final int VIEW_WIDTH = 0;
    private static final int VIEW_HEIGHT = 1;
    private static final int PIXEL = 2;

    private int value = 0;
    private int unit = 0;
    private int addition = 0;

    /**
     * Initiate unit
     * @param value int value of the unit
     * @param unit Unit type
     */
    private Unit(int value, int unit) {
        this.value = value;
        this.unit = unit;
    }

    /**
     * Initiate unit
     * @param value int value of the unit
     * @param unit Unit type
     * @param addition int addition to the value 
     */
    private Unit(int value, int unit, int addition) {
        this.value = value;
        this.unit = unit;
        this.addition = addition;
    }

    /**
     * Creates a new Unit instance for the given view width of the screen
     * vw of 50, means 50% in width of the canvas.
     * @param viewWidth int value of the view width
     * @return new Unit instance
     */
    public static Unit vw(int viewWidth) {
        return new Unit(viewWidth, Unit.VIEW_WIDTH);
    }

    /**
     * Creates a new Unit instance for the given view height of the screen
     * @param viewHeight int value of the view height
     * @return new Unit instance
     */
    public static Unit vh(int viewHeight) {
        return new Unit(viewHeight, Unit.VIEW_HEIGHT);
    }

    /**
     * Creates a new Unit instance for the given pixel value
     * @param pixel int value of the pixel
     * @return new Unit instance
     */
    public static Unit px(int pixel) {
        return new Unit(pixel, Unit.PIXEL);
    }
 
    /**
     * Subtract certain value of the unit value
     * @return subtracted value
     */
    public Unit subtract(Unit unit) {
        this.addition = -1 * unit.getValue();
        return this;
    }
    
    /**
     * Value getter for the given unit instance
     * @return int value of the unit
     */
    public int getValue() {
        switch (this.unit) {
            case Unit.VIEW_HEIGHT:
                return (int)(Infinity.instance.getHeight() / 100.0 * (double)this.value) + addition;
            case Unit.VIEW_WIDTH:
                return (int)(Infinity.instance.getWidth() / 100.0 * (double)this.value) + addition;
            case Unit.PIXEL:
                return this.value + addition;
            default:
                return 0;
        }
    }
}

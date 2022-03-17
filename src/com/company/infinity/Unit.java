package com.company.infinity;

public class Unit {
    private static final int VIEW_WIDTH = 0;
    private static final int VIEW_HEIGHT = 1;
    private static final int PIXEL = 2;

    private int value = 0;
    private int unit = 0;
    private int addition = 0;

    private Unit(int value, int unit) {
        this.value = value;
        this.unit = unit;
    }

    private Unit(int value, int unit, int addition) {
        this.value = value;
        this.unit = unit;
        this.addition = addition;
    }

    public static Unit vw(int viewWidth) {
        return new Unit(viewWidth, Unit.VIEW_WIDTH);
    }

    public static Unit vh(int viewHeight) {
        return new Unit(viewHeight, Unit.VIEW_HEIGHT);
    }

    public static Unit px(int pixel) {
        return new Unit(pixel, Unit.PIXEL);
    }

    public Unit subtract(Unit unit) {
        this.addition = -1 * unit.getValue();
        return this;
    }
    
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

package com.company.infinity;

public class Unit {
    private static final int VIEW_WIDTH = 0;
    private static final int VIEW_HEIGHT = 1;
    private static final int PIXEL = 2;

    private int value;
    private int unit;

    private Unit(int value, int unit) {
        this.value = value;
        this.unit = unit;
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
    
    public int getValue() {
        switch (this.unit) {
            case Unit.VIEW_HEIGHT:
                return (int)(Infinity.instance.getHeight() / 100.0 * (double)this.value);
            case Unit.VIEW_WIDTH:
                return (int)(Infinity.instance.getWidth() / 100.0 * (double)this.value);
            case Unit.PIXEL:
                return this.value;
            default:
                return 0;
        }
    }
}

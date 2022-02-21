package com.company.infinity;

public class Unit {
    private int value;
    private Units unit;

    public Unit(int value, Units unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Unit vw(int viewWidth) {
        return new Unit(viewWidth, Units.ViewWidth);
    }

    public static Unit vh(int viewHeight) {
        return new Unit(viewHeight, Units.ViewHeight);
    }

    public static Unit px(int pixel) {
        return new Unit(pixel, Units.Pixel);
    }

    public static Unit pct(int percentage) {
        return new Unit(percentage, Units.Percentage);
    }
    
    public int getValue() {
        switch (this.unit) {
            case ViewHeight:
                return (int)Infinity.instance.getHeight() / 100 * this.value;
            case ViewWidth:
                return (int)Infinity.instance.getWidth() / 100 * this.value;
            case Pixel:
                return this.value;
            case Percentage:
                return (int)Infinity.instance.getWidth() / 100 * this.value;
            default:
                return 0;
        }
    }
}

package com.company.infinity;

import java.util.ArrayList;
import org.jfree.fx.FXGraphics2D;
import java.awt.Color;

public class Table extends Node {
    
    private ArrayList<String> headers = new ArrayList<>();
    private ArrayList<String> rows = new ArrayList<>();

    public Table(int x, int y, Unit width, Unit height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        Infinity.instance.nodeList.add(this);
    }

    public void addHeader(String header) {
        this.headers.add(header);
    }

    public void addRow(String row) {
        this.rows.add(row);
    }

    public void addChild(int xIndex, int yIndex, Node child) {
        child.x = xIndex;
        child.y = yIndex;
        Infinity.instance.nodeList.add(child);
    }

    @Override
    public void draw() {
        FXGraphics2D context = Infinity.instance.context;

        Unit columnWidth = Unit.vw(100 / this.headers.size());
        Unit rowHeight = Unit.vh(100 / this.rows.size() + 1);

        Color[] color = { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN, Color.MAGENTA };

        for (int i = 0; i < this.headers.size(); i++) {
            context.setColor(color[i % color.length]);
            context.drawLine(x + columnWidth.getValue() * i, y, x + columnWidth.getValue() * i, height.getValue());
        }

        for (int i = 0; i < this.rows.size(); i++) {
            context.setColor(color[i % color.length]);
            context.drawLine(x, y + rowHeight.getValue() * i, width.getValue(), y + rowHeight.getValue() * i);
        }
    }

}

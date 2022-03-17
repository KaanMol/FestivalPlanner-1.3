package com.company.infinity;

import java.util.ArrayList;
import org.jfree.fx.FXGraphics2D;
import java.awt.Color;

public class Table extends Node {
    private Unit rowHeight = Unit.px(0);
    private Unit columnWidth = Unit.px(0);
    private ArrayList<String> columns = new ArrayList<>();
    private ArrayList<String> rows = new ArrayList<>();

    public Table(int x, int y, Unit width, Unit height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        System.out.println(this.width.getValue());
        System.out.println(this.height.getValue());
        Infinity.instance.nodeList.add(this);
    }

    public void addColumn(String header) {
        this.columns.add(header);
    }

    public void addRow(String row) {
        this.rows.add(row);
    }

    public void addCell(int xIndex, int yIndex, int xMultiplier, int yMultiplier, TableCell child) {
        child.x = xIndex + this.columnWidth.getValue();
        child.y = yIndex + this.rowHeight.getValue();
        child.width = Unit.px(this.columnWidth.getValue() * xMultiplier);
        child.height = Unit.px(this.rowHeight.getValue() * yMultiplier);
        child.zIndex = this.zIndex + 1;
        System.out.println(Infinity.instance.nodeList.nodes.size());
        Infinity.instance.nodeList.add(child);
        System.out.println(Infinity.instance.nodeList.nodes.size());
    }

    @Override
    public void update() {
        this.columnWidth = Unit.px(this.width.getValue() / this.columns.size());
        this.rowHeight = Unit.px(this.height.getValue() / this.rows.size());
    }

    @Override
    public void draw() {
        FXGraphics2D context = Infinity.instance.context;

        for (int rows = 0; rows < this.rows.size(); rows++) {
            for (int columns = 0; columns < this.columns.size(); columns++) {
                int leftX = this.x + columnWidth.getValue() * columns;
                int topY = this.y + rowHeight.getValue() * rows;
                int width = columnWidth.getValue();
                int height = rowHeight.getValue();

                if (rows == 0 || columns == 0) {
                    context.setColor(Color.LIGHT_GRAY);
                    context.fillRect(leftX, topY, width, height);
                } else {
                    context.setColor(Color.LIGHT_GRAY);
                    context.drawRect(leftX, topY, width, height);
                }

                context.setColor(Color.BLACK);
                    
                if (rows == 0 || columns == 0) {
                    context.drawString(this.columns.get(columns), leftX + (width / 2) - (context.getFontMetrics().stringWidth(this.columns.get(columns)) / 2), topY + (height / 2) + (context.getFontMetrics().getHeight() / 2));
                    context.drawString(this.rows.get(rows), leftX + (width / 2) - (context.getFontMetrics().stringWidth(this.columns.get(columns)) / 2), topY + (height / 2) + (context.getFontMetrics().getHeight() / 2));
                }
            }
        }
    }

}

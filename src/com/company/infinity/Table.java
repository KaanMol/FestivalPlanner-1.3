package com.company.infinity;

import java.util.ArrayList;
import org.jfree.fx.FXGraphics2D;
import java.awt.Color;

public class Table extends Node {
    private Unit rowWidth = Unit.vw(10);
    private Unit columnHeight = Unit.vh(10);
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

    public void addChild(int xIndex, int yIndex, Node child) {
        child.x = xIndex;
        child.y = yIndex;
        Infinity.instance.nodeList.add(child);
    }

    @Override
    public void draw() {
        FXGraphics2D context = Infinity.instance.context;

        int columnWidth = this.width.getValue() / this.columns.size();
        int rowHeight = this.height.getValue() / this.rows.size();

        Color[] color = { Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.CYAN, Color.MAGENTA };

        for (int rows = 0; rows < this.rows.size(); rows++) {
            for (int columns = 0; columns < this.columns.size(); columns++) {
                int leftX = this.x + columnWidth * columns;
                int topY = this.y + rowHeight * rows;
                int width = columnWidth;
                int height = rowHeight;

                

                if (rows == 0 || columns == 0) {
                    context.setColor(Color.LIGHT_GRAY);
                    context.fillRect(leftX, topY, width, height);
                //     // leftX = this.x + columnWidth * columns;
                //     // topY = this.y + rowHeight * rows;

                //     // if (rows == 0 && columns == 0) {
                //     //     leftX = this.x;
                //     //     topY = this.y;
                //     //     width = 100;
                //     //     height = 50;
                //     // }

                //     // if (rows == 0) {
                //     //     width = columnWidth;
                //     //     height = 50;
                //     // }

                //     // if (columns == 0) {
                //     //     height = rowHeight;
                //     //     width = 100;
                //     // }
                } else {
                    context.setColor(Color.LIGHT_GRAY);
                    context.drawRect(leftX, topY, width, height);
                    // context.setColor(color[(rows + columns) % color.length]);
                }
                // context.fillRect(leftX, topY, width, height);
                context.setColor(Color.BLACK);
                    
                if (rows == 0 || columns == 0) {
                    //draw columns on top and hours on left and center the text
                    context.drawString(this.columns.get(columns), leftX + (width / 2) - (context.getFontMetrics().stringWidth(this.columns.get(columns)) / 2), topY + (height / 2) + (context.getFontMetrics().getHeight() / 2));
                    context.drawString(this.rows.get(rows), leftX + (width / 2) - (context.getFontMetrics().stringWidth(this.columns.get(columns)) / 2), topY + (height / 2) + (context.getFontMetrics().getHeight() / 2));

                    // context.drawString(this.columns.get(columns), leftX + (width / 2) - (context.getFontMetrics().stringWidth(this.columns.get(columns)) / 2), topY + (height / 2) + (context.getFontMetrics().getHeight() / 2));
                    // context.drawString(this.rows.get(rows), leftX + width / 2, topY + height / 2);
                }
            }
        }
    }

}

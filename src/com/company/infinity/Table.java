package com.company.infinity;

import java.util.ArrayList;
import java.util.List;
import org.jfree.fx.FXGraphics2D;
import java.awt.Color;

/**
 * Table Component
 */
public class Table extends Node {
    private Unit rowHeight = Unit.px(0);
    private Unit columnWidth = Unit.px(0);
    private ArrayList<String> columns = new ArrayList<>();
    private ArrayList<String> rows = new ArrayList<>();

    /**
     * Initializes table
     * @param x left top x position of the table
     * @param y left top y position of the table
     * @param width width of the table
     * @param height height of the table
     */
    public Table(int x, int y, Unit width, Unit height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Creates columns for each element in the list
     * @param columns list of strings
     */
    public void columnsFromList(List columns) {
        for (Object column : columns) {
            this.addColumn(column.toString());
        }
    }

    /**
     * Adds column to the table
     * @param name name of the column
     */
    public void addColumn(String header) {
        if (this.columns.size() == 0) {
            this.columns.add("");
        }

        this.columns.add(header);
    }

    /**
     * Creates rows for each element in the list
     * @param rows list of strings
     */
    public void rowsFromList(List rows) {
        for (Object row : rows) {
            this.addRow(row.toString());
        }
    }

    /**
     * Adds row to the table
     * @param name name of the row
     */
    public void addRow(String row) {
        if (this.rows.size() == 0) {
            this.rows.add("");
        }

        this.rows.add(row);
    }

    /**
     * Links a TableCell to the table
     * @param xIndex x index of the cell
     * @param yIndex y index of the cell
     * @param xMultiplier float x multiplier of the cell, indicates width percentage of the cell, default: 1
     * @param yMultiplier float y multiplier of the cell, indicates height percentage of the cell, default: 1
     * @param child child node
     */
    public void addCell(int xIndex, int yIndex, float xMultiplier, float yMultiplier, TableCell child) {
        this.setWidthAndHeight();
        child.xIndex = xIndex;
        child.yIndex = yIndex;
        child.x = this.x + this.columnWidth.getValue() * (child.xIndex + 1);
        child.y = this.y + this.rowHeight.getValue() * (child.yIndex + 1);

        child.xMultiplier = xMultiplier;
        child.yMultiplier = yMultiplier;
        child.width = Unit.px(Math.round(this.columnWidth.getValue() * child.xMultiplier));
        child.height = Unit.px(Math.round(this.rowHeight.getValue() * child.yMultiplier));
        child.zIndex = this.zIndex + 1;
        child.parent = this + "";

        Infinity.instance.nodeList.add(child);
    }
    
    /**
     * Creates and adds a table cell to the table
     * @param xIndex x index of the cell
     * @param yIndex y index of the cell
     * @param xMultiplier int x multiplier of the cell, indicates width percentage of the cell, default: 1
     * @param yMultiplier int y multiplier of the cell, indicates height percentage of the cell, default: 1
     * @param child child node
     */
    public void addCell(int xIndex, int yIndex, int xMultiplier, int yMultiplier, TableCell child) {
        this.addCell(xIndex, yIndex, xMultiplier, yMultiplier, child);
    }


    /**
     * Sets width and height of the cells in the table
     */
    public void updateChildren() {
        this.setWidthAndHeight();
        ArrayList<Node> children = Infinity.instance.nodeList.getNodes();
        for (int i = 0; i < children.size(); i++) {
            Node node = children.get(i);

            if ((node instanceof TableCell) == false) {
                continue;
            }

            TableCell child = (TableCell) node;

            if (child.parent.equals(this + "")) {
                child.x = this.x + this.columnWidth.getValue() * (child.xIndex + 1);
                child.y = this.y + this.rowHeight.getValue() * (child.yIndex + 1);
                child.width = Unit.px(Math.round(this.columnWidth.getValue() * child.xMultiplier));
                child.height = Unit.px(Math.round(this.rowHeight.getValue() * child.yMultiplier));
                child.zIndex = this.zIndex + 1;
            }
        }
    }

    /**
     * Calculates the height and the width for the table
     */
    private void setWidthAndHeight() {
        this.columnWidth = Unit.px(this.width.getValue() / this.columns.size());
        this.rowHeight = Unit.px(this.height.getValue() / this.rows.size());
    }

    /**
     * Update method for the table
     */
    @Override
    public void update() {
        this.setWidthAndHeight();
        this.updateChildren();
    }

    /**
     * Draws the table
     */
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

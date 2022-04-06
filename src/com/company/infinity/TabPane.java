package com.company.infinity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * TabPane Component
 */
public class TabPane extends Node {
    private HashMap<String, Tab> tabs = new HashMap<>();
    private ArrayList<Button> buttons = new ArrayList<>();

    /**
     * Initializes TabPane
     * @param x left top x position of the tab pane
     * @param y left top y position of the table
     * @param width Unit instance for the width of the tab pane
     * @param height Unit instance for the height of the tab pane
     */
    public TabPane(int x, int y, Unit width, Unit height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        Infinity.instance.nodeList.setActiveIndex(0);
    }

    /**
     * Creates a new tab in Infinity
     * @param name name of the tab
     */
    public void addTab(String name) {
        this.tabs.put(name, new Tab());
        Button button = new Button(this.x + (101 * (this.buttons.size())), this.y, Unit.px(100), Unit.px(50), name);

        button.onMouseClick(callback -> {
            this.setActiveTab(name);
        });

        this.buttons.add(button);

        for (Button currentButton : buttons) {
            for (int i = 0; i < Infinity.instance.nodeList.getSize(); i++) {
                if (Infinity.instance.nodeList.getNodes(i).indexOf(currentButton) != -1) {
                    continue;
                }

                Infinity.instance.nodeList.getNodes(i).add(currentButton);
            }
        }
    }

    /**
     * Adds a child to the given tab
     * @param name of the tab
     * @param node Node instance
     */
    public void addNode(String name, Node node) {
        this.tabs.get(name).addNode(node);
    }

    /**
     * Sets the given tab as active
     * @param name name of the tab
     */
    public void setActiveTab(String name) {
        this.tabs.get(name).setActive();
    }
}

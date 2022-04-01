package com.company.infinity;

import java.util.ArrayList;
import java.util.HashMap;


public class TabPane extends Node {
    private HashMap<String, Tab> tabs = new HashMap<>();
    private ArrayList<Button> buttons = new ArrayList<>();
    
    public TabPane(int x, int y, Unit width, Unit height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        Infinity.instance.nodeList.setActiveIndex(0);
    }

    public void addTab(String name) {
        this.tabs.put(name, new Tab());
        Button button = new Button(this.x + (101 * (this.buttons.size())), this.y, Unit.px(100), Unit.px(50), name);

        button.onMouseClick(callback -> {
            System.out.println("Clicked on " + name);
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

    public void addNode(String name, Node node) {
        this.tabs.get(name).addNode(node);
    }

    public void setActiveTab(String name) {
        this.tabs.get(name).setActive();
    }
}

package com.company.infinity;

import java.util.ArrayList;
import java.util.Comparator;

public class NodeList {
    private ArrayList<ArrayList<Node>> nodes = new ArrayList<>() {{
        add(new ArrayList<>());
    }};
    private int activeIndex = 0;

    public void add(Node node) {
        this.nodes.get(this.activeIndex).add(node);
        this.nodes.get(this.activeIndex).sort(Comparator.comparingInt(Node::getZIndex));    
    }

    public Node get(int index) {
        return this.nodes.get(this.activeIndex).get(index);
    }

    public void setActiveIndex(int index) {
        if (index > this.nodes.size() - 1) {
            return;
        }
        this.activeIndex = index;
    }

    public void next() {
        this.activeIndex++;
    }

    public void previous() {
        if (this.activeIndex > 0) {
            this.activeIndex--;
        }
    }

    public ArrayList<Node> getNodes(int index) {
        return this.nodes.get(index);
    }

    public ArrayList<Node> getNodes() {
        return this.nodes.get(this.activeIndex);
    }

    public void addList() {
        this.nodes.add(new ArrayList<Node>());
    }

    public int getSize() {
        return this.nodes.size();
    }
}

package com.company.infinity;

public class Tab {
    private int index = 0;

    public Tab() {
        this.index = Infinity.instance.nodeList.getSize();
        Infinity.instance.nodeList.addList();
    }

    public void addNode(Node node) {
        Infinity.instance.nodeList.getNodes(this.index).add(node);
    }

    public int getIndex() {
        return this.index;
    }

    public void setActive() {
        Infinity.instance.nodeList.setActiveIndex(this.index);
    }
}

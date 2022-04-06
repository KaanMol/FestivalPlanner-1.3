package com.company.infinity;

/**
 * Tab class
 * Used in combination with TableCell
 */
public class Tab {
    private int index = 0;

    /**
     * Initializes Index of the Tab
     * Adds itself to the nodeList
     */
    public Tab() {
        this.index = Infinity.instance.nodeList.getSize();
        Infinity.instance.nodeList.addList();
    }

    /**
     * Adds child to this tab
     * @param node Node instance 
     */
    public void addNode(Node node) {
        Infinity.instance.nodeList.getNodes(this.index).add(node);
    }

    /**
     * Getter for the tab index
     * @return index of the tab
     */
    public int getIndex() {
        return this.index;
    }

    /**
     * Sets this tab as active
     */
    public void setActive() {
        Infinity.instance.nodeList.setActiveIndex(this.index);
    }
}

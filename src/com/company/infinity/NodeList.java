package com.company.infinity;

import java.util.ArrayList;
import java.util.Comparator;

public class NodeList {
    public ArrayList<Node> nodes = new ArrayList<>();

    public void add(Node node) {
        this.nodes.add(node);
        this.nodes.sort(Comparator.comparingInt(Node::getZIndex));    
    }

    public Node get(int index) {
        return this.nodes.get(index);
    }
}

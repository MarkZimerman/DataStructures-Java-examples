package Graphs;

import java.util.*;

public class MyGraph {
    Map<Node, List<Node>> nodes = new HashMap<>();

    private class Node {
        String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    public void addNode(String label) {
        nodes.putIfAbsent(new Node(label), null);
    }

    private Node getNode(String label) {
        return nodes.keySet().stream().filter(n -> n.label.equals(label)).findFirst().orElse(null);
    }

    public void removeNode(String label) {
        Node target = getNode(label);
        System.out.println("Removing node: " + target);
        List<Node> connections;
        for (Node node: nodes.keySet()){
            connections = nodes.get(node);
            if (connections != null)
                connections.remove(target);
        }

        nodes.remove(target);
    }

    public void addEdge(String from, String to) {
        Node fromNode = getNode(from);
        Node toNode = getNode(to);
        List<Node> connections = nodes.get(fromNode);
        if (connections == null) {
            nodes.put(fromNode, new ArrayList<>());
            nodes.get(fromNode).add(toNode);
            return;
        }

        if (connections.contains(toNode)) return;
        connections.add(toNode);
    }

    public void removeEdge(String from, String to) {
        Node fromNode = getNode(from);
        Node toNode = getNode(to);
        List<Node> connections = nodes.get(fromNode);
        if (!connections.contains(toNode)) return;
        connections.remove(toNode);
    }

    public void traverse(String label) {
        Set<Node> edges = new HashSet<>();
        Node root = getNode(label);
        traverse(root, edges);

        System.out.println(edges);
    }

    private void traverse(Node root, Set<Node> edges) {
        System.out.println("Node checking (root): " + root);
//        if (edges.contains(root)) return;
        if (nodes.get(root) == null) return;

        for (Node node : nodes.get(root)) {
            System.out.println("    " + root + " connected to " + node);
            edges.add(node);
            traverse(node, edges);
        }
    }

    public void print(){
        for (Node node: nodes.keySet()){
            System.out.println(node + " is connected with " + nodes.get(node));
        }
    }
}

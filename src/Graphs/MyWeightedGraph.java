package Graphs;

import java.util.*;

public class MyWeightedGraph {
    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private class Edge {
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + " --(" + weight + ")-> " + to;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, ArrayList<Edge>> connections = new HashMap<>();

    public void addNode(String label) {
        if (label == null) return;
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        connections.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to, int weight){
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (fromNode == null || toNode == null) throw new IllegalArgumentException();

        connections.get(fromNode).add(new Edge(fromNode, toNode, weight));
        connections.get(toNode).add(new Edge(toNode, fromNode, weight));
    }

    public void print() {
        for (Node source : connections.keySet()){
            List<Edge> targets = connections.get(source);
            if (targets != null)
                System.out.println(source + " is connected to " + targets);
        }
    }
}

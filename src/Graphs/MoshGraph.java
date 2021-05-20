package Graphs;

import java.util.*;

public class MoshGraph {
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

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> connections = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, new Node(label));
        connections.putIfAbsent(node, null);
    }

    public void addEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        if (fromNode == null) throw new IllegalArgumentException();

        Node toNode = nodes.get(to);
        if (toNode == null) throw new IllegalArgumentException();

//        System.out.println("Add " + toNode + " to " + fromNode + ", " + fromNode + "'s connections: " + connections.get(fromNode));
        if (connections.get(fromNode) == null) {
            connections.put(fromNode, new ArrayList<>());
        }
        connections.get(fromNode).add(toNode);
        // For uni-directional Graphs add:
        // connections.get(toNode).add(fromNode);
    }

    public void removeNode(String label) {
        Node target = nodes.get(label);
        if (target == null) return;

        for (Node source: connections.keySet())
            connections.get(source).remove(target);

        connections.remove(target);
        nodes.remove(label);
    }

    public void removeEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if (fromNode == null || toNode == null) return;

        connections.get(fromNode).remove(toNode);
    }

    public void traverseDepthFirst(String label) {
        Node node = nodes.get(label);
        if (node == null) return;
        traverseDepthFirstRec(node, new HashSet<>());
    }

    private void traverseDepthFirstRec(Node root, Set<Node> visited) {
        System.out.println(root);
        visited.add(root);
        if (connections.get(root) == null) return;

        for (Node node: connections.get(root))
            if (!visited.contains(node))
                traverseDepthFirstRec(node, visited);
    }

    public void traverseDepthFirstIter(String label) {
        Node node = nodes.get(label);
        if (node == null) return;

        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            if(visited.contains(current)) continue;

            System.out.println(current);
            visited.add(current);

            if (connections.get(current) == null) continue;
            for (Node neighbour: connections.get(current)) {
                if (!visited.contains(neighbour)) {
                    stack.push(neighbour);
                }
            }
        }
    }

    public void traverseBreadthFirstIter(String label) {
        Node node = nodes.get(label);
        if (node == null) return;

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.remove();

            if(visited.contains(current)) continue;

            System.out.println(current);
            visited.add(current);

            if (connections.get(current) == null) continue;
            for (Node neighbour: connections.get(current)) {
                if (!visited.contains(neighbour)) {
                    queue.add(neighbour);
                }
            }
        }
    }

    public void print() {
        for (Node source : connections.keySet()){
            List<Node> targets = connections.get(source);
            if (targets != null)
                System.out.println(source + " is connected to " + targets);
        }
    }

    public List<String> topologicalSort() {
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        for (Node node : nodes.values())
            topologicalSort(node, visited, stack);

        List<String> sorted = new ArrayList<>();
        while (!stack.isEmpty())
            sorted.add(stack.pop().label);

        return sorted;
    }

    private void topologicalSort(Node root, Set<Node> visited, Stack<Node> stack) {
        if (visited.contains(root)) return;
        visited.add(root);

        if (connections.get(root) != null)
            for (Node neighbour : connections.get(root))
                topologicalSort(neighbour, visited, stack);

        stack.push(root);
    }

    public boolean hasCycle() {
        Set<Node> all = new HashSet<>();
        all.addAll(nodes.values());

        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        while (!all.isEmpty()) {
            Node current = all.iterator().next();
            if (hasCycle(current, all, visiting, visited)) return true;
        }
        return false;
    }

    private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
        all.remove(node);
        visiting.add(node);

        if (connections.get(node) != null) {
            for (Node neighbour : connections.get(node)) {
                if (visited.contains(neighbour)) continue;
                if (visiting.contains(neighbour)) return true;
                if (hasCycle(neighbour, all, visiting, visited)) return true;
            }
        }

        visiting.remove(node);
        visited.add(node);

        return false;
    }
}

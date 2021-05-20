package Test;

import java.util.ArrayList;
import java.util.List;

/* TASK:

    class Node {
        public List<Node> child = new ArrayList();
    }
    // Нужно написать:
    class Util {
        public static List<Node> toFlatList(Node n){
            return null;
        }
    }
 */


public class Main3 {

    public static void main(String[] args) {

        Node rootNode = new Node();
        Node innerNode1 = new Node();
        Node innerNode2 = new Node();
        List<Node> listOfNodes1 = new ArrayList<>();
        List<Node> listOfNodes2 = new ArrayList<>();
        listOfNodes1.add(new Node());
        listOfNodes1.add(new Node());
        listOfNodes1.add(new Node());
        listOfNodes2.add(new Node());
        listOfNodes2.add(new Node());

        /*
        Node node = new Node("main node");
        Node innerNode1 = new Node("innerNode1");
        Node innerNode2 = new Node("innerNode2");
        List<Node> listOfNodes1 = new ArrayList<>();
        List<Node> listOfNodes2 = new ArrayList<>();
        listOfNodes1.add(new Node("al1-1"));
        listOfNodes1.add(new Node("al1-2"));
        listOfNodes1.add(new Node("al1-3"));
        listOfNodes2.add(new Node("al2-1"));
        listOfNodes2.add(new Node("al2-2"));
        */

        innerNode2.child = listOfNodes2;
        innerNode1.child = listOfNodes1;
        rootNode.child.add(innerNode1);
        rootNode.child.add(innerNode2);

        System.out.println(Util.toFlatList(rootNode));
    }
}

class Node {
    List<Node> child = new ArrayList();

    /*
    String value;

    public Node(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.getClass().;
    }
     */
}

class Util {
    public static List<Node> toFlatList(Node n){
        List<Node> result = new ArrayList<>();
        toFlatList(n, result);

        return result;
    }

    private static void toFlatList(Node n, List<Node> result) {
        if (n.child == null || n.child.isEmpty()) return;

        for (Node node : n.child) {
            result.add(node);
            toFlatList(node, result);
        }
    }
}
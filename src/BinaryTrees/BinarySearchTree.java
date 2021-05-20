package BinaryTrees;

class Node {
    public int value;
    public Node left, right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class BinarySearchTree {
    public static boolean contains(Node root, int value) {
        if (root == null) throw new IllegalStateException();

        /**
         * Note:
         * If I understand the task right: the ROOT value is also a part of subtree?
         * Otherwise the next condition is not needed
         */
        if (root.value == value) return true;

        Node current = root;
        while (current != null){
            if (value < current.value)
                current = current.left;
            else if (value > current.value)
                current = current.right;
            else
                return true;
        }
        return false;

        /*
        if (value > root.value) return false;
        if (root.value == value) return true;

        Node current = root;
        Node last = current;
        while (current != null) {
            System.out.println("cur=" + current.value);
            last = current;
            if (current.value == value) {
                return true;
            }
            current = current.left;
        }
        return false;

         */
    }

    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);

        System.out.println(contains(n2, 2));
    }
}

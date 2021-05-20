package BinaryTrees;

public class MyBinaryTree {
    Node root;

    public void insert(int value){
        Node node = new Node(value);

        if (isEmpty()){
            this.root = node;
            return;
        }

        Node current = root;
        while (true){
            if (value < current.value){
                if (current.leftChild == null){
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null){
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value){
        Node current = root;
        while (current != null){
            if (value < current.value)
                current = current.leftChild;
            else if (value > current.value)
                current = current.rightChild;
            else
                return true;
        }
        return false;
    }

    public void traversePreOrder(){
        traversePreOrder(root);
    }

    public void traverseInOrder(){
        traverseInOrder(root);
    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }

    public int height(){
        return height(root);
    }

    public int min(){
        return min(root);
    }

    public boolean equal(MyBinaryTree other){
        if (other == null) return false;
        return equal(root, other.root);
    }

    public boolean checkBinarySearchTree(){
        return checkBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    private boolean checkBinarySearchTree(Node root, int min, int max){
        if (root == null) return true;
        if (root.value < min || root.value > max) return false;

        return checkBinarySearchTree(root.leftChild, min, root.value - 1)
                    && checkBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    public void findKthNode(int distance){
        if (distance > height()) throw new IllegalArgumentException();
        findKthNode(root, distance);
    }

    private void findKthNode(Node root, int distance){
        if (root == null) return;
//        System.out.println(root.value + " dist=" + distance);
        if (distance == 0) {
            System.out.println(root.value);
            return;
        }
        findKthNode(root.leftChild, distance - 1);
        findKthNode(root.rightChild, distance - 1);
    }

    private boolean equal(Node first, Node second){
        if (first == null && second == null) return true;
        if (first != null && second != null)
            return first.value == second.value
                    && equal(first.leftChild, second.leftChild)
                    && equal(first.rightChild, second.rightChild);
        return false;
    }

    private void traversePreOrder(Node root){
        if (root == null) return;
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }


    private void traverseInOrder(Node root){
        if(root == null) return;
        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }


    private void traversePostOrder(Node root){
        if(root == null) return;
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    // Post-Order traversing
    private int height(Node root){
        if (root == null)
            return -1;

        if (isLeaf(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    // Most finding left down node in Binary Search Tree
    private int minBST(){
        if (root == null) throw new IllegalStateException();
        Node current = root;
        Node last = current;
        while (current != null){
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    // Post-Order traversing for Binary Trees
    private int min(Node root){
        if (isLeaf(root))
            return root.value;

        int left = min(root.leftChild);
        int right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    private boolean isLeaf(Node node){
        return node.leftChild == null && node.rightChild == null;
    }

    private class Node {
        private Node leftChild;
        private Node rightChild;
        private int value;

        public Node(int value){
            this.value = value;
        }
    }

    public boolean isEmpty(){
        return root == null;
    }
}
package BinaryTrees;

public class MyAvlTree {
    Node root;

    public void insert(int value){
        root = insert(root, value);
    }

    // My Recursion Version (works)
    public void insert2(int value){
        if (root == null) {
            root = new Node(value);
            return;
        }

        insert2(root, value);
    }

    private void insert2(Node root, int value){
        if (value < root.value){
            if (root.leftChild == null){
                root.leftChild = new Node(value);
                return;
            }
            insert2(root.leftChild, value);
        } else {
            if (root.rightChild == null){
                root.rightChild = new Node(value);
                return;
            }
            insert2(root.rightChild, value);
        }
    }

    private Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.value) {
            root.leftChild = insert(root.leftChild, value);
        } else {
            root.rightChild = insert(root.rightChild, value);
        }

//        root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;
        setHeight(root);

//        balance(root);
//        return root;
        return balance(root);
    }

    private Node balance(Node root){
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.leftChild) < 0) {
                System.out.println("Left rotate " + root.leftChild.value);
                root.leftChild = rotateLeft(root.leftChild);
            }
            System.out.println("Right rotate " + root.value);
            return rotateRight(root);
        }
        else if (isRightHeavy(root)){
            if (balanceFactor(root.rightChild) > 0){
                System.out.println("Right rotate " + root.rightChild.value);
                root.rightChild = rotateRight(root.rightChild);
            }
            System.out.println("Left rotate " + root.value);
            return rotateLeft(root);
        }
        return root;
    }

    private boolean isRightHeavy(Node node){
        return balanceFactor(node) < -1;
    }

    private boolean isLeftHeavy(Node node){
        return balanceFactor(node) > 1;
    }

    private int balanceFactor(Node node){
        return height(node.leftChild) - height(node.rightChild);
    }

    private Node rotateLeft(Node root){
        Node newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private Node rotateRight(Node root){
        Node newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private void setHeight(Node node){
        node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
    }

    private int height(Node node){
        return (node == null) ? -1 : node.height;
    }


    private class Node {
        Node leftChild;
        Node rightChild;
        int value;
        int height;

        public Node(int value){
            this.value = value;
        }
    }
}

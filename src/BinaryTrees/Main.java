package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
/*
        String fruit = "stawberries";
        System.out.println(fruit.substring(2, 5));
        System.out.println(Boolean.parseBoolean("FalSe"));
        MyBinaryTree tree = new MyBinaryTree();

        List arr = new ArrayList();
        arr.add("fg");
        arr.add(2);

        System.out.println("Java Version: " + System.getProperty("java.version"));

        System.out.println(tree.isEmpty());
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);

        System.out.println("Created");
        System.out.println(tree.find(1));
        System.out.println("------------------------");
        tree.traversePostOrder();
        System.out.println("Height: " + tree.height());
        System.out.println("Min: " + tree.min());

//        MyBinaryTree tree2 = new MyBinaryTree();
//        tree2.insert(7);
//        tree2.insert(4);
//        tree2.insert(6);
//        tree2.insert(1);
//        tree2.insert(9);
//        tree2.insert(8);
//        tree2.insert(10);
//        System.out.println("Equal: " + tree.equal(tree2));
        System.out.println("------------------------");
        System.out.println("Is Binary Search Tree? " + tree.checkBinarySearchTree());
        System.out.println("------------------------");
        tree.findKthNode(0);
        */

        MyAvlTree tree = new MyAvlTree();
        tree.insert(10);
        tree.insert(30);
        tree.insert(20);
//        tree.insert(1);
//        tree.insert(6);
//        tree.insert(8);
//        tree.insert(10);
        System.out.println("done");
    }
}

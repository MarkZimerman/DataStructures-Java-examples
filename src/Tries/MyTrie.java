package Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyTrie {
    public static final int ALPHABET_SIZE = 26;
    Node root = new Node(' ');

    private class Node {
        private char value;
//       private Node[] children = new Node[ALPHABET_SIZE];
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        public boolean hasChild(char ch){
            return this.children.containsKey(ch);
        }

        public void addChild(char ch){
            this.children.put(ch, new Node(ch));
        }

        public Node getChild(char ch){
            return this.children.get(ch);
        }

        public Node[] getChildren(){
            return this.children.values().toArray(new Node[0]);
        }

        public boolean hasChildren(){
            return !this.children.isEmpty();
        }

        public void removeChild(char ch){
            this.children.remove(ch);
        }
    }

    public void insert(String word){
        Node current = root;
        for (char ch: word.toCharArray()){
            if (!current.hasChild(ch))
                current.addChild(ch);
            current = current.getChild(ch);

//            int index = ch - 'a';
//            if (current.children[index] == null)
//                current.children[index] = new Node(ch);
//            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word){
        if (word == null) return false;
        Node current = root;
        for (char ch: word.toCharArray()){
            if (!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public void traverse(){
        traverse(root);
    }

    private void traverse(Node root){
        // Pre-order (asc):
//        System.out.println(root.value);
//        for (Node child: root.getChildren())
//            traverse(child);
//
        // Post-order (desc):
        for (Node child: root.getChildren())
            traverse(child);
        System.out.println(root.value);
    }

    public void remove(String word){
        if (word == null) return;
        remove(root, word, 0);
    }

    private void remove(Node root, String word, int index){
        if (index == word.length()) {
            root.isEndOfWord = false;
            return;
        }
        char ch = word.charAt(index);
        Node child = root.getChild(ch);
        if (child == null) return;

        remove(child, word, index + 1);

        if (!child.hasChildren() && !child.isEndOfWord)
            root.removeChild(ch);
    }

    public List<String> findWords(String prefix) {
        List<String> words = new ArrayList<>();
        Node lastNode = findLastNodeOf(prefix);
        findWords(lastNode, prefix, words);

        return words;
    }

    private void findWords(Node root, String prefix, List<String> words) {
        if (root == null) return;

        if (root.isEndOfWord)
            words.add(prefix);

        for (Node child : root.getChildren()){
            findWords(child, prefix + child.value, words);
        }
    }

    // Similar to contains
    private Node findLastNodeOf(String prefix){
        if (prefix == null) return null;

        Node current = root;
        for (char ch: prefix.toCharArray()){
            Node child = current.getChild(ch);
            if (child == null)
                return null; // no prefix in this trie
            current = child;
        }
        return current; // last node of this prefix

    }

}

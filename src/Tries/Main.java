package Tries;

public class Main {
    public static void main(String[] args) {
        MyTrie trie = new MyTrie();
/*
        trie.insert("car");
        trie.insert("care");
        System.out.println("Done");
        String testWord = "car";
        System.out.println("Contains '" + testWord + "': " + trie.contains(testWord));
        trie.traverse();
        trie.remove("car");
        System.out.println("Contains '" + testWord + "': " + trie.contains(testWord));
        testWord = "care";
        System.out.println("Contains '" + testWord + "': " + trie.contains(testWord));
*/

        trie.insert("car");
        trie.insert("card");
        trie.insert("care");
        trie.insert("careful");
        trie.insert("egg");
        System.out.println(trie.findWords(null));
    }
}

package trie;

import java.util.HashMap;

public class TrieWithHashMap {

    public static int ALPHABET_SIZE = 26;

    private class Node {

        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public void removeChild(char ch) {
            children.remove(ch);
        }

    }

    private Node root = new Node(' ');

    public void insert(String word) {

        var current = root;
        for (var ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                current.addChild(ch);

            current = current.getChild(ch);
        }
        current.isEndOfWord = true;

    }

    public boolean contains(String word) {

        if (word == null)
            return false;
        var current = root;
        for (var ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                return false;

            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public void traverse() {
        traverse(root);
    }

    // Pre-Order
    // private void traverse(Node root) {
    // System.out.println(root.value);

    // for (var child : root.getChildren())
    // traverse(child);

    // }

    // Post-Order
    private void traverse(Node root) {

        for (var child : root.getChildren())
            traverse(child);

        System.out.println(root.value);

    }

    public void remove(String word) {
        if (word == null)
            return;
        remove(root, word, 0);
    }

    private void remove(Node root, String word, int index) {
        if (index == word.length()) {
            root.isEndOfWord = false;
            return;
        }

        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if (child == null)
            return;

        remove(child, word, index + 1);
        if (!child.hasChildren() && !child.isEndOfWord) {
            root.removeChild(ch);
        }
    }
}

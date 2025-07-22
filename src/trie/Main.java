package trie;

public class Main {

    public static void main(String[] args) {

        TrieWithHashMap trie = new TrieWithHashMap();
        trie.insert("canada");
        trie.insert("dog");
        // trie.remove("dog");
        System.out.println(trie.contains("canada"));
        System.out.println(trie.contains("dog"));
        // trie.traverse();
    }

}

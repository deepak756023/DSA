package trie;

public class Main {

    public static void main(String[] args) {

        TrieWithHashMap trie = new TrieWithHashMap();
        trie.insert("canada");
        // trie.insert("cat");
        System.out.println(trie.contains("can"));
    }

}

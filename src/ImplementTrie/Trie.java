package ImplementTrie;

import java.util.HashMap;

/**
 * Created by haha on 2015/5/16.
 */
class TrieNode {
    HashMap<Character, TrieNode> tail;
    boolean end;
    // Initialize your data structure here.
    public TrieNode() {
        tail = new HashMap<Character, TrieNode>();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode r = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!r.tail.containsKey(ch)){
                r.tail.put(ch, new TrieNode());
            }
            r = r.tail.get(ch);
        }
        r.end = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode r = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!r.tail.containsKey(ch)) return false;
            r = r.tail.get(ch);
        }
        return r.end;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode r = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(!r.tail.containsKey(ch)) return false;
            r = r.tail.get(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("a");
        t.insert("ab");
        System.out.println(t.search("a"));
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");

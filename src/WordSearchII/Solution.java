package WordSearchII;

import java.util.*;

/**
 * Created by haha on 2015/6/7.
 */
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word: words)
            trie.insert(word);
        HashSet<String> result = new HashSet<String>();
        boolean[][] trace = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                solver(board, trace, "", i, j, trie, result);
            }
        }
        return new ArrayList<String>(result);
    }

    void solver(char[][] board, boolean[][] trace, String curStr, int i, int j, Trie trie, HashSet<String> result){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || trace[i][j]) return;
        curStr += board[i][j];
        if(!trie.startsWith(curStr)) return;
        if(trie.search(curStr)) result.add(curStr);
        trace[i][j] = true;
        solver(board, trace, curStr, i + 1, j, trie, result);
        solver(board, trace, curStr, i - 1, j, trie, result);
        solver(board, trace, curStr, i, j + 1, trie, result);
        solver(board, trace, curStr, i, j - 1, trie, result);
        trace[i][j] = false;
    }

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
    }
}

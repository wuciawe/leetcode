package AddSearchWord;

import java.util.HashMap;

/**
 * Created by haha on 2015/5/16.
 */
public class WordDictionary {
    private class TrieNode{
        boolean end;
        HashMap<Character, TrieNode> tail = new HashMap<Character, TrieNode>();
    }

    private TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode r = root;
        for(int i = 0; i < word.length(); ++i){
            char ch = word.charAt(i);
            if(!r.tail.containsKey(ch))
                r.tail.put(ch, new TrieNode());
            r = r.tail.get(ch);
        }
        r.end = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(root, 0, word.length(), word);
    }

    private boolean search(TrieNode r, int idx, int len, String word){
        if(idx == len) return r.end;
        char ch = word.charAt(idx);
        boolean res = false;
        if(ch == '.'){
            for(TrieNode te: r.tail.values())
                res = res || search(te, idx + 1, len, word);
        }else{
            if(!r.tail.containsKey(ch)) return false;
            res = search(r.tail.get(ch), idx + 1, len, word);
        }
        return res;
    }
}

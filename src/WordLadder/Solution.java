package WordLadder;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if(beginWord.equals(endWord)) return 1;

        int len = beginWord.length();
        wordDict.remove(beginWord);
        wordDict.add(endWord);
        HashSet<Character> charset = new HashSet<Character>();
        for(String w: wordDict){
            for(int i = 0; i < len; ++i){
                charset.add(w.charAt(i));
            }
        }

        int res = 1;
        List<String> candies = new ArrayList<String>();
        candies.add(beginWord);
        while(!candies.isEmpty() && !wordDict.isEmpty()){
            ++res;
            List<String> ncandies = new ArrayList<String>();
            for(String s:candies){
                StringBuilder w = new StringBuilder(s);
                for(int i = 0; i < len; ++i){
                    char ch = s.charAt(i);
                    for(char c : charset){
                        if(c != ch){
                            w.setCharAt(i, c);
                            String word = w.toString();
                            if(wordDict.contains(word)){
                                if(word.equals(endWord)){
                                    return res;
                                }
                                wordDict.remove(word);
                                ncandies.add(word);
                            }
                        }
                    }
                    w.setCharAt(i, ch);
                }
            }
            candies = ncandies;
        }
        return 0;
    }

    private int solver(String beginWord, String endWord, Set<String> wordDict){
        StringBuilder word = new StringBuilder();
        word.append(beginWord);
        HashSet<String> candy = new HashSet<String>();
        for(int i = 0; i < beginWord.length(); ++i){
            char ch = beginWord.charAt(i);
            for(char c = 'a'; c <= 'z'; ++c){
                if(c != ch){
                    word.setCharAt(i, c);
                    String w = word.toString();
                    if(wordDict.contains(w)){
                        if(w.equals(endWord))
                            return 2;
                        wordDict.remove(w);
                        candy.add(w);
                    }
                }
            }
            word.setCharAt(i, ch);
        }
        for(String w: candy){
            int res = solver(w, endWord, wordDict);
            if(res != 0){
                return res + 1;
            }
        }
        return 0;
    }
}

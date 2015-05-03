package WordBreak;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        return solver(s, wordDict, 0, s.length(), new HashSet<Integer>());
    }

    private boolean solver(String s, Set<String> wordDict, int cur, int len, HashSet<Integer> fail){
        for(int r = cur + 1; r <= len; ++r){
            if(wordDict.contains(s.substring(cur, r))){
                if(r == len) return true;
                if(!fail.contains(r)){
                    boolean res = solver(s, wordDict, r, len, fail);
                    if(res){
                        return true;
                    }else{
                        fail.add(r);
                    }
                }
            }
        }
        return false;
    }
}

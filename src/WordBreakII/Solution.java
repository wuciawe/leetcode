package WordBreakII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jwhu on 4/16/15.
 */
public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<String>();
        if(s == null) return result;
        int maxStep = 0;
        for(String e : wordDict){
            int len = e.length();
            if(len > maxStep) maxStep = len;
        }
        solve(result, wordDict, s, 0, s.length(), maxStep, "", "");
        return result;
    }

    private static void solve(List<String> result, Set<String> wordDict, String s, int lb, int rb, int maxStep, String ls, String rs){
        if(lb == rb){
            if(!ls.equals("")){
                if(!rs.equals("")) result.add(ls + " " + rs);
                else result.add(ls);
            }else{
                if(!rs.equals("")) result.add(rs);
            }
            return;
        }
        for(int leftStep = 1, l = lb + 1; leftStep <= maxStep && l <= rb; ++leftStep, ++l){
            String lc = s.substring(lb, l);
            if(wordDict.contains(lc)) {
                if(l == rb) {
                    String ltmp;
                    if(ls.equals("")) ltmp = lc;
                    else ltmp = ls + " " + lc;
                    if(!ltmp.equals("")){
                        if(!rs.equals("")) result.add(ltmp + " " + rs);
                        else result.add(ltmp);
                    }else{
                        if(!rs.equals("")) result.add(rs);
                    }
                }else{
                    for(int rightStep = 1, r = rb - 1; rightStep <= maxStep && r >= l; ++rightStep, --r){
                        String rc = s.substring(r, rb);
                        if(wordDict.contains(rc)){
                            String ltmp;
                            String rtmp;
                            if(ls.equals("")) ltmp = lc;
                            else ltmp = ls + " " + lc;
                            if(rs.equals("")) rtmp = rc;
                            else rtmp = rc + " " + rs;
                            solve(result, wordDict, s, l, r, maxStep, ltmp, rtmp);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Set<String> wordDict = new HashSet<String>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        sol.wordBreak("catdog", wordDict);
    }
}

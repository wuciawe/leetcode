package IsomorphicStrings;

import java.util.HashMap;

/**
 * Created by haha on 2015/4/29.
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sm = new int[200];
        int[] st = new int[200];
        for(int i = s.length() - 1; i >= 0; --i){
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            if(sm[chs] != st[cht]) return false;
            sm[chs] = i;
            st[cht] = i;
        }
        return true;
    }
}

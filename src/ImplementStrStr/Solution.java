package ImplementStrStr;

/**
 * Created by haha on 2015/4/25.
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.equals("")) return 0;
        final int hlen = haystack.length();
        final int nlen = needle.length();
        for(int i = 0; i <= hlen - nlen; ++i){
            if(haystack.substring(i, i + nlen).equals(needle)) return i;
        }
        return -1;
    }
}

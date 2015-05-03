package LongestCommonPrefix;

/**
 * Created by haha on 2015/4/12.
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
//        if(strs == null || strs.length == 0) return "";
//        int len = strs.length;
//        String fs = strs[0];
//        if(len == 1) return fs;
//        int fl = fs.length();
//        for(int idx = 0; idx < fl; ++idx){
//            char c = fs.charAt(idx);
//            for(int i = 1; i < len; ++i){
//                String cs = strs[i];
//                if(idx == cs.length() || cs.charAt(idx) != c){
//                    return fs.substring(0, idx);
//                }
//            }
//        }
//        return fs;
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        String minSt = strs[0];
        int mlen = minSt.length();
        for (String st: strs){
            int len = st.length();
            if(len < mlen){
                minSt = st;
                mlen = len;
            }
        }
        for (int i=0; i<minSt.length(); ++i) {
            for (String st: strs)
                if (st.charAt(i) != minSt.charAt(i))
                    return minSt.substring(0, i);
        }
        return minSt;
    }
}

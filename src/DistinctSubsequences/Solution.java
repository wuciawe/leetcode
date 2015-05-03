package DistinctSubsequences;

/**
 * Created by haha on 2015/5/1.
 */
public class Solution {
    public int numDistinct(String s, String t) {
        int r = solver(s.toCharArray(), 0, t.toCharArray(), 0, new int[s.length() + 1][t.length() + 1]);
        return r == -1 ? 0 : r;
    }

    private int solver(char[] s, int si, char[] t, int ti, int[][] cache){
        if(cache[si][ti] != 0){
            return cache[si][ti];
        }else if(ti == t.length){
            cache[si][ti] = 1;
            return 1;
        }else if(si < s.length){
            int res = 0;
            for(int i = si; i < s.length; ++i){
                if(s[i] == t[ti]){
                    int r = solver(s, i + 1, t, ti + 1, cache);
                    if(r != -1) res += r;
                }
            }
            if(res == 0) res = -1;
            cache[si][ti] = res;
            return res;
        }else{
            cache[si][ti] = -1;
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numDistinct("rabbbit", "rabbit"));
    }
}

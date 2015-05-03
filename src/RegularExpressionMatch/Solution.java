package RegularExpressionMatch;

/**
 * Created by haha on 2015/4/19.
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();

        if(slen == 0 && plen == 0) return true;
        if(plen == 0) return false;

        boolean[][] res = new boolean[plen + 1][slen + 1];
        res[0][0] = true;

        for(int pi = 0; pi < plen; ++pi){
            if(p.charAt(pi) == '*'){
                if(pi == 0) continue;
                if(res[pi - 1][0]) res[pi + 1][0] = true;
                if(p.charAt(pi - 1) == '.'){
                    int si = 0;
                    while(si < slen && !res[pi][si + 1] && !res[pi - 1][si + 1])
                        ++si;
                    for(; si < slen; ++si) res[pi + 1][si + 1] = true;
                }else{
                    for(int si = 0; si < slen; ++si){
                        if(res[pi][si + 1] || res[pi - 1][si + 1] || si > 0 && res[pi + 1][si] && s.charAt(si) == s.charAt(si - 1) && s.charAt(si - 1) == p.charAt(pi - 1))
                            res[pi + 1][si + 1] = true;
                    }
                }
            }else{
                for(int si = 0; si < slen; ++si){
                    if(res[pi][si] && (s.charAt(si)==p.charAt(pi) || p.charAt(pi)=='.'))
                        res[pi + 1][si + 1] = true;
                }
            }
        }

        return res[plen][slen];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isMatch("aa", "aaaa"));
    }
}

package ValidPalindrome;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    final private int bias = 'A' - 'a';

    public boolean isPalindrome(String s) {
        if(s.equals("")) return true;
        int[] cur = new int[2];
        int l = glb(s, 0, s.length() - 1, cur);
        int r = grb(s, l, s.length() - 1, cur);
        while(l < r){
            if(cur[0] != cur[1]) return false;
            l = glb(s, l + 1, r - 1, cur);
            r = grb(s, l, r - 1, cur);
        }
        return true;
    }

    private int glb(String s, int l, int r, int[] cur){
        if(l > r) return l;
        char ch = s.charAt(l);
        if(ch >= 'A' && ch <= 'Z'){
            cur[0] = ch - bias;
            return l;
        }
        if(ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9'){
            cur[0] = ch;
            return l;
        }
        return glb(s, l + 1, r, cur);
    }

    private int grb(String s, int l, int r, int[] cur){
        if(l > r) return r;
        char ch = s.charAt(r);
        if(ch >= 'A' && ch <= 'Z'){
            cur[1] = ch - bias;
            return r;
        }
        if(ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9'){
            cur[1] = ch;
            return r;
        }
        return grb(s, l, r - 1, cur);
    }
}

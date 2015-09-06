package ValidAnagram;

/**
 * Created by haha on 2015/9/6.
 */
public class Solution {
    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;
        int[] c = new int[200];
        for(int i = 0; i < s.length(); ++i){
            --c[s.charAt(i)];
            ++c[t.charAt(i)];
        }
        for(int i = 'a'; i <= 'z'; ++i){
            if(c[i] != 0) return false;
        }
        return true;
    }
}

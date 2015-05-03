package LongestSubstringNoRepeat;

import sun.security.util.Length;

import java.util.HashMap;

/**
 * Created by haha on 2015/4/12.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put(s.charAt(0), 0);
        int result = 0;
        int idx = 1;
        int cur = 0;
        while(idx < s.length()){
            char c = s.charAt(idx);
            if(map.containsKey(c)){
                int tmp = idx - cur;
                result = result > tmp ? result : tmp;
                int ncur = map.get(c) + 1;
                while(cur < ncur){
                    map.remove(s.charAt(cur++));
                }
            }
            map.put(c, idx);
            ++idx;
        }
        int tmp = idx - cur;
        return result > tmp ? result : tmp;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLongestSubstring("abba"));
        System.out.println(sol.lengthOfLongestSubstring("bbbbbb"));
        System.out.println(sol.lengthOfLongestSubstring("b"));
    }
}

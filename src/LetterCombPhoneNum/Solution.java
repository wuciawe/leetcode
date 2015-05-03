package LetterCombPhoneNum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by haha on 2015/4/24.
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits == null || digits.length() == 0) return result;
        solve(result, new HashSet<String>(), "", digits);
        return result;
    }

    private void solve(List<String> result, HashSet<String> cache, String pre, String cur){
        if(cur.length() == 0 && cache.add(pre)){
            result.add(pre);
            return;
        }

        int dig = cur.charAt(0) - '2';
        String ncur = cur.substring(1);
        if(dig < 5){
            for(int i = 0; i < 3; ++i){
                char ch = (char)('a' + i + dig * 3);
                solve(result, cache, pre + Character.toString(ch), ncur);
            }
        }else if(dig == 5){
            for(int i = 0; i < 4; ++i){
                char ch = (char)('p' + i);
                solve(result, cache, pre + Character.toString(ch), ncur);
            }
        }else if(dig == 6){
            for(int i = 0; i < 3; ++i){
                char ch = (char)('t' + i);
                solve(result, cache, pre + Character.toString(ch), ncur);
            }
        }else if(dig == 7){
            for(int i = 0; i < 4; ++i){
                char ch = (char)('w' + i);
                solve(result, cache, pre + Character.toString(ch), ncur);
            }
        }else if(dig == -2){
            solve(result, cache, pre + " ", ncur);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.letterCombinations("23");
    }
}

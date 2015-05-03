package LongestValidParentheses;

import java.util.Stack;

/**
 * Created by haha on 2015/4/26.
 */
public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() < 2) return 0;

        int result = 0;
        int[] record = new int[s.length()];
        int rc = 0;
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '('){
                ++rc;
            }else{
                if(rc > 0){
                    --rc;
                    record[i] = 2;
                    if(s.charAt(i - 1) == ')'){
                        record[i] += record[i - 1];
                    }
                    if(i - record[i] >= 0){
                        record[i] += record[i - record[i]];
                    }
                    if(record[i] > result){
                        result = record[i];
                    }
                }
            }
        }

        return result;
    }
}

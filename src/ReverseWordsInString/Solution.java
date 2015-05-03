package ReverseWordsInString;

import java.util.Stack;

/**
 * Created by haha on 2015/4/30.
 */
public class Solution {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<String>();
        for(int start = 0; start < s.length(); ++start){
            if(s.charAt(start) != ' '){
                int end = start + 1;
                for(; end < s.length(); ++end){
                    if(s.charAt(end) == ' '){
                        stack.add(s.substring(start, end));
                        start = end;
                        break;
                    }
                }
                if(end == s.length()){
                    stack.add(s.substring(start));
                    start = end;
                }
            }
        }
        if(stack.isEmpty()) return "";
        else{
            String res = stack.pop();
            while(!stack.isEmpty()){
                res += " " + stack.pop();
            }
            return res;
        }
    }
}

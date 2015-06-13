package BasicCalculator;

import java.util.Stack;

/**
 * Created by haha on 2015/6/13.
 */
public class Solution {
    public int calculate(String s) {
        int res = 0;
        char[] cArr = s.toCharArray();
        Stack<Integer> signs = new Stack<>();
        signs.push(1); // global sign
        signs.push(1); // current sign
        for(int i = 0; i < cArr.length; ++i){
            if(cArr[i] >= '0'){
                int num = 0;
                while(i < cArr.length && cArr[i] >= '0')
                    num = 10 * num + cArr[i++] - '0';
                res += signs.pop() * num;
                --i;
            }else if(cArr[i] == ')'){ // corresponding to sign added by '('
                signs.pop();
            }else if(cArr[i] != ' '){ // update current sign for '(' '+' '-'
                signs.push(signs.peek() * (cArr[i] == '-' ? -1 : 1));
            }
        }
        return res;
    }
}

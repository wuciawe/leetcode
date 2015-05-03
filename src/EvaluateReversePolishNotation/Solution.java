package EvaluateReversePolishNotation;

import java.util.Stack;

/**
 * Created by haha on 2015/4/30.
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < tokens.length; ++i){
            if(tokens[i].length() == 1){
                char ch = tokens[i].charAt(0);
                switch (ch){
                    case '+':
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case '-':
                        stack.push(-stack.pop() + stack.pop());
                        break;
                    case '*':
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case '/':
                        int a = stack.pop();
                        stack.push(stack.pop() / a);
                        break;
                    default:
                        stack.push(ch - '0');
                        break;
                }
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}

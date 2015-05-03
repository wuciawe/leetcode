package SimplifyPath;

import java.util.Stack;

/**
 * Created by haha on 2015/5/1.
 */
public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack  = new Stack<String>();

        int i = 0;
        while(i < path.length()){
            if(path.charAt(i) == '/'){
                StringBuilder sb = new StringBuilder();
                ++i;
                while(i < path.length()){
                    char ch = path.charAt(i);
                    if(ch == '/'){
                        break;
                    }else{
                        sb.append(ch);
                        ++i;
                    }
                }
                String sub = sb.toString();
                if(sub.equals("..")){
                    if(!stack.isEmpty())
                        stack.pop();
                }else if(!sub.equals("") && !sub.equals(".")){
                    stack.push(sub);
                }
            }
        }
        if(stack.isEmpty()){
            return "/";
        }else{
            String res = "/" + stack.pop();
            while(!stack.isEmpty()){
                res = "/" + stack.pop() + res;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.simplifyPath("/abc/...");
    }
}

package MinStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by haha on 2015/4/27.
 */
public class MinStack {

    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> min = new Stack<Integer>();

    public void push(int x) {
        stack.push(x);
        if(min.isEmpty() || x <= min.peek()){
            min.push(x);
        }
    }

    public void pop() {
        if(!stack.isEmpty()){
            int x = stack.pop();
            if(x == min.peek()){
                min.pop();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

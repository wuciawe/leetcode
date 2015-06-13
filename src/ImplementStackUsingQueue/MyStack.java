package ImplementStackUsingQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by haha on 2015/6/13.
 */
class MyStack {
    Queue<Integer> queue = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        for(int i = queue.size(); i > 1; --i)
            queue.add(queue.remove());
        queue.remove();
    }

    // Get the top element.
    public int top() {
        for(int i = queue.size(); i > 1; --i)
            queue.add(queue.remove());
        int res = queue.remove();
        queue.add(res);
        return res;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
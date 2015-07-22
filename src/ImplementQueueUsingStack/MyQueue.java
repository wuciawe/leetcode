package ImplementQueueUsingStack;

import java.util.Stack;

/**
 * Created by jwhu on 7/22/15.
 */
public class MyQueue {
    private Stack<Integer> head = new Stack<>();
    private Stack<Integer> tail = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        tail.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(head.isEmpty()){
            while(!tail.isEmpty()) head.push(tail.pop());
        }
        head.pop();
    }

    // Get the front element.
    public int peek() {
        if(head.isEmpty()){
            while(!tail.isEmpty()) head.push(tail.pop());
        }
        return head.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return head.isEmpty() && tail.isEmpty();
    }
}

package datastructures.stack.impl;

public class QueueViaStack {
    Stack<Integer> stack1 = null;
    Stack<Integer> stack2 = null;

    /**
     * Initialize your data structure here.
     */
    public QueueViaStack() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (empty()) return -1;
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (empty()) return -1;
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        if (stack1.isEmpty() && stack2.isEmpty()) return true;
        return false;
    }
}
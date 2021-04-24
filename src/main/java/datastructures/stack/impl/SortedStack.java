package datastructures.stack.impl;

import java.util.Stack;

public class SortedStack {

    public void sortStack(Stack<Integer> stack) {
        Stack<Integer> stack2 = new Stack<>();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!stack2.isEmpty() && stack2.peek() > temp) {
                stack.push(stack2.pop());
            }
            stack2.push(temp);
        }
        while (!stack2.isEmpty()) stack.push(stack2.pop());
    }

    public static void main(String[] args) {
        SortedStack sortedStack = new SortedStack();
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(6);
        stack.push(7);
        stack.push(5);
        stack.push(8);
        stack.push(4);
        stack.push(3);
        sortedStack.sortStack(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}

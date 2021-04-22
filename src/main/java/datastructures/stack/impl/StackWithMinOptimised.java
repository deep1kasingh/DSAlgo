package datastructures.stack.impl;

/**
 * reference to the class: StackWithMin.java. We would need to maintain the min element with every node of the stack.
 * It is not an optimised version many nodes end having the same min element. in this case why store the min with every node.
 * Another way can be to keep a separate stack that just maintains the minimum elements in the stack
 */

public class StackWithMinOptimised extends java.util.Stack<Integer> {
    Stack<Integer> stack2 = new Stack<>();

    public Integer push(Integer value) {
        if (value <= getMin()) {
            stack2.push(value);
        }
        super.push(value);
        return value;
    }

    public Integer pop() {
        Integer popped = super.pop();
        if (popped == getMin()) stack2.pop();
        return popped;
    }

    public Integer getMin() {
        if (stack2.isEmpty()) return Integer.MAX_VALUE; // error value
        return stack2.peek();
    }


    public static void main(String[] args) {
        StackWithMinOptimised swm = new StackWithMinOptimised();
        swm.push(10);
        swm.push(1);
        swm.push(5);
        swm.push(9);
        swm.push(1);
        while (!swm.isEmpty()) {
            System.out.println(swm.getMin());
            swm.pop();
        }
    }
}

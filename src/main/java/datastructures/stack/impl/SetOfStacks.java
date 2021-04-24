package datastructures.stack.impl;

public class SetOfStacks extends java.util.Stack<java.util.Stack<Integer>> {
    int threshold = 10;

    public SetOfStacks(int threshold) {
        this.threshold = threshold;
    }

    public void push(Integer val) {
        if (super.isEmpty() || super.peek().size() == this.threshold) {
            java.util.Stack<Integer> newStack = new java.util.Stack<>();
            newStack.push(val);
            super.push(newStack);
        } else {
            java.util.Stack<Integer> topStack = super.peek();
            topStack.push(val);
        }
    }

    public Integer customPop() {
        if (super.isEmpty()) return -1;
        java.util.Stack<Integer> topStack = super.peek();
        Integer val = topStack.peek();
        topStack.pop();
        if (super.peek().size() == 0) {
            super.pop();
        }
        return val;
    }

    public static void main(String[] args) {
        SetOfStacks setOfStacks = new SetOfStacks(1);
        setOfStacks.push(10);
        setOfStacks.push(20);
        setOfStacks.push(30);
        while (!setOfStacks.isEmpty()) {
            System.out.println(setOfStacks.customPop());
        }
    }

}

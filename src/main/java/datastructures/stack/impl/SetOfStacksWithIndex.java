package datastructures.stack.impl;

import java.util.LinkedList;

public class SetOfStacksWithIndex extends LinkedList<Stack<Integer>> {
    int threshold;

    public SetOfStacksWithIndex(int threshold) {
        this.threshold = threshold;
    }

    public void push(Integer val) {
        if (this.size() == 0 || this.getLast().size() == this.threshold) {
            Stack<Integer> newStack = new Stack<>();
            newStack.push(val);
            this.addLast(newStack);
        } else {
            this.getLast().push(val);
        }
    }

    public Integer customPop() {
        Stack<Integer> topStack = this.getLast();
        if (this.size() == 0) return -1;
        Integer val = topStack.pop();
        if (topStack.size() == 0) this.removeLast();
        return val;
    }

    /**
     * Popping element at an index means that some stacks might not be at full capacity in the list
     */
    public Integer popAtIndex(int i) {
        if (i < this.size()) {
            if (this.get(i).size() > 0) {
                Integer val = this.get(i).pop();
                if (this.get(i).size() == 0) {
                    this.remove(i);
                }
                return val;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SetOfStacksWithIndex setOfStacks = new SetOfStacksWithIndex(1);
        setOfStacks.push(10);
        setOfStacks.push(20);
        setOfStacks.push(30);
        System.out.println("Pop element of stack at index = 2: " + setOfStacks.popAtIndex(2));
        while (!setOfStacks.isEmpty()) {
            System.out.println(setOfStacks.customPop());
        }
    }
}

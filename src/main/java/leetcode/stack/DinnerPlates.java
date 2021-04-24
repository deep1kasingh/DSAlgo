package leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DinnerPlates {
    int capacity = 0;
    int curr = 0;
    int last = 0;
    List<Stack<Integer>> listOfStacks;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        this.listOfStacks = new ArrayList<>();
    }

    public void push(int val) {
        while (curr < this.listOfStacks.size() && this.listOfStacks.get(curr).size() == this.capacity) {
            curr++;
        }
        if (curr == this.listOfStacks.size()) {
            Stack<Integer> newStack = new Stack<Integer>();
            newStack.push(val);
            this.listOfStacks.add(newStack);
        } else {
            this.listOfStacks.get(curr).push(val);
        }
        last = Integer.max(curr, last);
    }

    public int pop() {
        while (last >= 0 && this.listOfStacks.get(last).size() == 0) {
            last--;
        }
        if (last >= 0) {
            return this.listOfStacks.get(last).pop();
        }
        return -1;
    }

    public int popAtStack(int index) {
        if (index > this.listOfStacks.size() || this.listOfStacks.get(index).size() == 0) return -1;
        Integer val = this.listOfStacks.get(index).pop();
        curr = Integer.min(curr, index);
        return val;
    }


    public static void main(String[] args) {
        DinnerPlates D = new DinnerPlates(1);
        D.push(1);
        D.push(2);
        D.push(3);
        D.push(4);
        D.push(5);         // The stacks are now:  2  4
        System.out.println(D.popAtStack(1));   // Returns 2.  The stacks are now:     4
        D.push(20);        // The stacks are now: 20  4
        D.push(21);        // The stacks are now: 20  4 21
        System.out.println(D.popAtStack(0));   // Returns 20.  The stacks are now:     4 21
        System.out.println(D.popAtStack(2));   // Returns 21.  The stacks are now:     4
        System.out.println(D.pop());            // Returns 5.  The stacks are now:      4
        System.out.println(D.pop());            // Returns 4.  The stacks are now:   1  3
        System.out.println(D.pop());            // Returns 3.  The stacks are now:   1
        System.out.println(D.pop());            // Returns 1.  There are no stacks.
        System.out.println(D.pop());
    }
}

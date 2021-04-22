package datastructures.stack.impl;

class NodeWithMin {
    int value;
    int min;

    NodeWithMin(int value, int min) {
        this.value = value;
        this.min = min;
    }
}

public class StackWithMin extends java.util.Stack<NodeWithMin> {
    void push(int value) {
        int min = Math.min(getMin(), value);
        super.push(new NodeWithMin(value, min));
    }

    Integer getMin() {
        if (super.isEmpty()) return Integer.MAX_VALUE;
        else return super.peek().min;
    }

    public static void main(String[] args) {
        StackWithMin swm = new StackWithMin();
        swm.push(10);
        swm.push(1);
        swm.push(5);
        swm.push(9);
        while (!swm.isEmpty()) {
            System.out.println(swm.getMin());
            swm.pop();
        }
    }
}



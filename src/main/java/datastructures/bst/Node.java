package datastructures.bst;

public class Node {
    protected int val;
    protected Node left;
    protected Node right;

    protected Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

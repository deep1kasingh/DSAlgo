package datastructures.binarytrees;

public class TreeNode {
    int val;
    TreeNode left = null, right = null;
    boolean isLeft;
    TreeNode parentNode;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val, boolean isLeft, TreeNode parentNode) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.isLeft = isLeft;
        this.parentNode = parentNode;
    }
}

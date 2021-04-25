package datastructures;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parentNode;
    public boolean isLeft;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val, boolean isLeft, TreeNode parentNode) {
        this.val = val;
        this.isLeft = isLeft;
        if (isLeft) {
            this.parentNode.left = new TreeNode(val);
        } else {
            this.parentNode.right = new TreeNode(val);
        }
    }

}

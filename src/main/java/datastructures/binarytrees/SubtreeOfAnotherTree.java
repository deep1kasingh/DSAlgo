package datastructures.binarytrees;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        if (s.val != t.val) {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        } else {
            return isSubtree(s.left, t.left) && isSubtree(s.right, t.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
    }
}

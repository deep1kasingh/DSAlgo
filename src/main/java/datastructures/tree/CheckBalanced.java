package datastructures.tree;

import datastructures.TreeNode;

public class CheckBalanced {
    public boolean isBalanced(TreeNode root) {
        int treeHeight = height(root);
        if (treeHeight == -1) return false;
        return true;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = new MinimalTree().createTree(arr);
        /*TreeNode curr = root;
        while (curr.left != null) curr = curr.left;
        curr.left = new TreeNode(11);
        curr.left.left = new TreeNode(12);*/
        System.out.println(new CheckBalanced().isBalanced(root));
    }
}

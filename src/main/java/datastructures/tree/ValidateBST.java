package datastructures.tree;

import datastructures.TreeNode;

public class ValidateBST {

    public boolean validateBST(TreeNode node) {
        return validateBSTAux(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean validateBSTAux(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if (node.val > max || node.val <= min) return false;
        return validateBSTAux(node.left, min, node.val) && validateBSTAux(node.right, node.val, max);
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        TreeNode root = new MinimalTree().createTree(arr);
//        TreeNode curr = root;
//        while (curr.left != null) curr = curr.left;
//        curr.left = new TreeNode(8);
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(10);
//        root.left.right = new TreeNode(6);
        root.right = new TreeNode(20);
        System.out.println(new ValidateBST().validateBST(root));
    }
}
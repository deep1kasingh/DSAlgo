package datastructures.tree;

import datastructures.TreeNode;

public class Successor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode node) {
        if (node.right != null) {
            TreeNode curr = node.right;
            while (curr.left != null) curr = curr.left;
            return curr;
        } else {
            return findLeftParent(root, node, null);
        }
    }

    private TreeNode findLeftParent(TreeNode root, TreeNode node, TreeNode parent) {
        if (root == null) return null;
        if (root == node) return parent;
        TreeNode leftSearch = findLeftParent(root.left, node, root);
        TreeNode rightSearch = findLeftParent(root.right, node, parent);
        if (leftSearch == null) return rightSearch;
        else return leftSearch;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        System.out.println(new Successor().inorderSuccessor(root, root.left.right).val);
    }
}

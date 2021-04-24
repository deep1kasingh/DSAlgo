package datastructures.tree;

import datastructures.TreeNode;
import datastructures.bst.BinarySearchTree;

public class MinimalTree {

    public TreeNode createTree(int[] arr) {
        int mid = (0 + arr.length - 1) / 2;
        return createNode(0, arr.length - 1, arr);
    }

    private TreeNode createNode(int low, int high, int[] arr) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            TreeNode node = new TreeNode(arr[mid]);
            node.left = createNode(low, mid - 1, arr);
            node.right = createNode(mid + 1, high, arr);
            return node;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = new MinimalTree().createTree(arr);
        new BinarySearchTree().inorderRec(root);
    }
}

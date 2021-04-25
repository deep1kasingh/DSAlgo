package datastructures.binarytrees;

import datastructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InsertionLevelOrder {
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    private TreeNode insert(TreeNode root, int x) {
        if (root == null) return new TreeNode(x);
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        boolean flagInserted = false;
        while (!treeNodeQueue.isEmpty() && !flagInserted) {
            TreeNode currNode = treeNodeQueue.poll();
            if (currNode.left != null) {
                treeNodeQueue.add(currNode.left);
            } else {
                currNode.left = new TreeNode(x);
                flagInserted = true;
            }
            if (currNode.right != null && !flagInserted) {
                treeNodeQueue.add(currNode.right);
            } else {
                currNode.right = new TreeNode(x);
                flagInserted = true;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(11);
        root.left.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(8);

        InsertionLevelOrder insertionLevelOrder = new InsertionLevelOrder();
//        insertionLevelOrder.inorder(root);
        insertionLevelOrder.insert(root, 12);
        insertionLevelOrder.inorder(root);
    }
}

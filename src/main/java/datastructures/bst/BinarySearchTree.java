package datastructures.bst;

import datastructures.TreeNode;

public class BinarySearchTree {
    //root of the binary search bst
    TreeNode root = null;

    // inorder tranversal of the bst
    public void inorder() {
        inorderRec(root);
    }

    public void inorderRec(TreeNode root) {
        if (root == null) return;
        inorderRec(root.left);
        System.out.println(root.val);
        inorderRec(root.right);
    }

    public TreeNode search(int value) {
        return searchRec(root, value);
    }

    private TreeNode searchRec(TreeNode node, int value) {
        if (node == null || node.val == value) return node;
        if (node.val < value) return searchRec(node.right, value);
        else return searchRec(node.left, value);
    }

    private TreeNode insertRec(TreeNode node, int value) throws Exception {
        if (node == null) {
            return new TreeNode(value);
        }
        if (node.val == value) throw new Exception("Value already exists");
        if (node.val < value) node.right = insertRec(node.right, value);
        else node.left = insertRec(node.left, value);
        return node;
    }

    public void insert(int value) throws Exception {
        root = insertRec(root, value);
    }

    public void deleteKey(int value) {
    }

    public static void main(String[] args) throws Exception {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        bst.inorder();
    }
}



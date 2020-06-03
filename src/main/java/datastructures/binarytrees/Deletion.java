package datastructures.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

public class Deletion {

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    private TreeNode deleteKey(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key && root.left == null && root.right == null) return null;
        //find the rightmost node of the tree
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        int rightMostNodeValue = -1;
        while (!treeNodeQueue.isEmpty()) {
            TreeNode currNode = treeNodeQueue.poll();
            if (currNode.left != null) {
                treeNodeQueue.add(currNode.left);
            }
            if (currNode.right != null) {
                treeNodeQueue.add(currNode.right);
            }
            if (treeNodeQueue.isEmpty()) {
                rightMostNodeValue = currNode.val;
                if (currNode.isLeft) {

                    currNode.parentNode.left = null;
                } else {

                    currNode.parentNode.right = null;
                }
            }
        }
        treeNodeQueue.add(root);
        boolean isDeleted = false;
        while (!treeNodeQueue.isEmpty() && !isDeleted) {
            TreeNode currNode = treeNodeQueue.poll();
            if (currNode.val == key) {
                currNode.val = rightMostNodeValue;
                isDeleted = true;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        //Test case 1
/*        TreeNode root = new TreeNode(10, false, null);
        root.left = new TreeNode(11, true, root);
        root.left.left = new TreeNode(7, true, root.left);
        root.right = new TreeNode(9, false, root);
        root.right.left = new TreeNode(15, true, root.right);
        root.right.right = new TreeNode(8, false, root.right);

        Deletion deletion = new Deletion();
//        deletion.inorder(root);
        deletion.deleteKey(root, 10);
        deletion.inorder(root);*/

        //Test case 2
        Deletion deletion = new Deletion();
        TreeNode root = new TreeNode(10, false, null);

//        deletion.inorder(root);
        root = deletion.deleteKey(root, 10);
        deletion.inorder(root);
    }
}

package datastructures.bst;

import datastructures.TreeNode;

public class ConstructBstFromPreorder extends BinarySearchTree {
    private TreeNode construct(int[] preorderTraversal) {
        TreeNode root = new TreeNode(preorderTraversal[0]);
        constructRec(preorderTraversal, 1, root);
        return root;
    }

    private int constructRec(int[] preorderTraversal, int indx, TreeNode node) {
        return -1;
    }

    public static void main(String[] args) {
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        ConstructBstFromPreorder cbfp = new ConstructBstFromPreorder();
        cbfp.root = cbfp.construct(pre);
        cbfp.inorder();
    }
}

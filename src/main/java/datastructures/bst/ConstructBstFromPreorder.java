package datastructures.bst;

import datastructures.Node;

public class ConstructBstFromPreorder extends BinarySearchTree {
    private Node construct(int[] preorderTraversal) {
        Node root = new Node(preorderTraversal[0]);
        constructRec(preorderTraversal, 1, root);
        return root;
    }

    private int constructRec(int[] preorderTraversal, int indx, Node node) {
        return -1;
    }

    public static void main(String[] args) {
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        ConstructBstFromPreorder cbfp = new ConstructBstFromPreorder();
        cbfp.root = cbfp.construct(pre);
        cbfp.inorder();
    }
}

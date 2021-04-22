package datastructures.bst.impl;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insertRec(1);
        bst.insertRec(100);
        bst.insertRec(50);
        bst.insertRec(35);
        bst.insertRec(10);
        bst.insertRec(150);
        bst.insertRec(135);
        bst.insertRec(170);

//        bst.delete(100);
//        bst.delete(35);
//        bst.delete(1);
//        bst.inorder();
        bst.levelOrder();
    }
}

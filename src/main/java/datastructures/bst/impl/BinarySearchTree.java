package datastructures.bst.impl;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {

    int size = 0;
    Node<T> root = null;

    public static class Node<T> {
        T val;
        Node<T> left = null;
        Node<T> right = null;

        Node(T val, Node<T> left, Node<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void insert(T val) {
        Node newNode = new Node<T>(val, null, null);
        if (root == null) {
            root = newNode;
        } else {
            Node<T> trav = root;
            Node<T> prev = null;
            boolean isLeft = false;
            while (trav != null) {
                prev = trav;
                if (val.compareTo(trav.val) < 0) {
                    trav = trav.left;
                    isLeft = true;
                } else {
                    trav = trav.right;
                    isLeft = false;
                }
            }
            if (isLeft) {
                prev.left = newNode;
            } else {
                prev.right = newNode;
            }
        }
        size++;
    }

    public void insertRec(T val) {
        this.root = insertRecHelper(this.root, val);
    }

    public Node<T> insertRecHelper(Node<T> root, T val) {
        if (root == null) root = new Node<T>(val, null, null);
        if (val.compareTo(root.val) < 0) {
            root.left = insertRecHelper(root.left, val);
        } else {
            root.right = insertRecHelper(root.right, val);
        }
        return root;
    }

    public void inorder() {
        inorderRec(this.root);
    }

    private void inorderRec(Node<T> root) {
        if (root == null) return;
        inorderRec(root.left);
        System.out.println(root.val);
        inorderRec(root.right);
    }

    public boolean delete(T val) {
        if(contains(val)){
            this.root = deleteRec(this.root, val);
            size--;
            return true;
        }
        return false;
    }

    private Node<T> deleteRec(Node<T> root, T val) {
        if (val.compareTo(root.val) == 0) {
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                T succVal = findPre(root.left);
                root.val = succVal;
                root.left = deleteRec(root.left, succVal);
            }
        } else if (val.compareTo(root.val) < 0) {
            root.left = deleteRec(root.left, val);
        } else {
            root.right = deleteRec(root.right, val);
        }
        return root;
    }

    private T findPre(Node<T> root) {
        if (root.right == null) {
            return root.val;
        } else {
            return findPre(root.right);
        }
    }

    public void levelOrder() {
        Queue<Node<T>> queue = new LinkedList<>();
        if(this.root !=null) queue.add(this.root);
        while(!queue.isEmpty()){
            Node<T> trav = queue.remove();
            System.out.println(trav.val);
            if(trav.left != null) queue.add(trav.left);
            if(trav.right != null) queue.add(trav.right);
        }
    }

    private boolean contains(T val){
        return containsRec(this.root, val);
    }

    private boolean containsRec(Node<T> root, T val){
        if(root == null) return false;
        if(root.val == val) {
            return true;
        } else if(val.compareTo(root.val) < 0){
            return containsRec(root.left, val);
        } else {
            return containsRec(root.right, val);
        }
    }
}

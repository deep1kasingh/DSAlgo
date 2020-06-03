package datastructures.bst;

public class BSTDeletion extends BinarySearchTree {
    public void deleteKey(int value) {
        root = deleteRec(root, value);
    }

    private Node deleteRec(Node node, int value) {
        if (node == null) return null;
        if (node.val == value) {
            // the key to be deleted is a leaf
            if (node.left == null) {
                return node.right;
            }
            // the key to be deleted has only one child
            else if (node.right == null) {
                return node.left;
            } else {
                // find node successor
                Node nodeSucc = findNodeSucc(node.right);
                node.val = nodeSucc.val;
                node.right = deleteRec(node.right, node.val);
                return node;
            }
        }
        if (node.val < value) node.right = deleteRec(node.right, value);
        else node.left = deleteRec(node.left, value);
        return node;
    }

    private Node findNodeSucc(Node node) {
        while(node.left != null) node = node.left;
        return node;
    }

    public static void main(String[] args) throws Exception {
        BinarySearchTree bst = new BSTDeletion();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        bst.insert(100);
        bst.deleteKey(20);
        bst.deleteKey(30);
        bst.deleteKey(70);
        bst.inorder();
    }
}

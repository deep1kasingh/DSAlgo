package datastructures.binarytrees;

public class DiameterOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return heightRecur(root, 0)[1];
    }

    private int[] heightRecur(TreeNode root, int maxHeight) {
        if (root == null) return new int[]{0, 0};
        int leftHeight = 1 + heightRecur(root.left, maxHeight)[0];
        int rightHeight = 1 + heightRecur(root.right, maxHeight)[0];
        return new int[]{(leftHeight < rightHeight ? rightHeight : leftHeight),
                leftHeight + rightHeight - 1 > maxHeight ? leftHeight + rightHeight - 2 : maxHeight};
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        int result = new DiameterOfBinaryTree().diameterOfBinaryTree(root);
        System.out.println(result);
    }
}

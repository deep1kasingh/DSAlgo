package datastructures.binarytrees;

public class MirrorOfItself {

    private boolean isMirrorTree(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        return compareTrees(root, root);
    }

    private boolean compareTrees(TreeNode temp1, TreeNode temp2) {
        if (temp1 == null && temp2 == null) return true;
        if (temp1 == null || temp2 == null) return false;
        return temp1.val == temp2.val && compareTrees(temp1.left, temp2.right) && compareTrees(temp1.right, temp2.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        MirrorOfItself mirrorOfItself = new MirrorOfItself();
        System.out.println(mirrorOfItself.isMirrorTree(root));
    }
}

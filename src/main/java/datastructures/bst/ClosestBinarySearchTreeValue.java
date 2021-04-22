package datastructures.bst;

import javafx.util.Pair;

public class ClosestBinarySearchTreeValue {
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

    public int closestValue(TreeNode root, double target) {
        return closestValueRecur(root, new Pair<>(null, Double.MAX_VALUE), target).getKey();
    }

    private Pair<Integer, Double> closestValueRecur(TreeNode root, Pair<Integer, Double> minPair, double target) {
        if (root != null) {
            double currDiff = Math.abs(root.val - target);
            if (currDiff < minPair.getValue()) {
                minPair = new Pair<>(root.val, currDiff);
            }
            Pair<Integer, Double> leftPair = closestValueRecur(root.left, minPair, target);
            Pair<Integer, Double> rightPair = closestValueRecur(root.right, minPair, target);
            if (leftPair.getValue() < minPair.getValue()) {
                minPair = leftPair;
            }
            if (rightPair.getValue() < minPair.getValue()) {
                minPair = rightPair;
            }
        }
        return minPair;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        int result = new ClosestBinarySearchTreeValue().closestValue(root, 3.714286);
        System.out.println(result);
    }
}


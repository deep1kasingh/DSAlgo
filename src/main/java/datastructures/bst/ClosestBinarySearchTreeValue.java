package datastructures.bst;

import datastructures.TreeNode;

import java.util.AbstractMap;
import java.util.Map;


class Pair {
    // Return a map entry (key-value pair) from the specified values
    public static <T, U> Map.Entry<T, U> of(T first, U second) {
        return new AbstractMap.SimpleEntry<>(first, second);
    }
}

public class ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        return closestValueRecur(root, Pair.of(null, Double.MAX_VALUE), target).getKey();
    }

    private Map.Entry<Integer, Double> closestValueRecur(TreeNode root, Map.Entry<Integer, Double> minPair, double target) {
        if (root != null) {
            double currDiff = Math.abs(root.val - target);
            if (currDiff < minPair.getValue()) {
                minPair = Pair.of(root.val, currDiff);
            }
            Map.Entry<Integer, Double> leftPair = closestValueRecur(root.left, minPair, target);
            Map.Entry<Integer, Double> rightPair = closestValueRecur(root.right, minPair, target);
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


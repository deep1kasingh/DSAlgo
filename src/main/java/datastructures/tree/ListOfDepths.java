package datastructures.tree;

import datastructures.TreeNode;

import java.util.*;

public class ListOfDepths {
    public List<List<TreeNode>> createLinkedListAtDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        List<List<TreeNode>> listOfLists = new ArrayList<>(); // list of nodes
        int i = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (!queue.isEmpty()) queue.offer(null);
                i++;
                continue;
            }
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            if (i == listOfLists.size()) {
                listOfLists.add(new ArrayList<>(Arrays.asList(node)));
            } else {
                listOfLists.get(i).add(node);
            }
        }
        return listOfLists;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = new MinimalTree().createTree(arr);
        List<List<TreeNode>> listOfLists = new ListOfDepths().createLinkedListAtDepth(root);
        for (int i = 0; i < listOfLists.size(); i++) {
            for (int j = 0; j < listOfLists.get(i).size(); j++) {
                System.out.print(listOfLists.get(i).get(j).val);
            }
            System.out.println();
        }
    }
}
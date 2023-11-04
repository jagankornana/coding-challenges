package com.poc.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindLargestValueInEachTreeRow {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        FindLargestValueInEachTreeRow obj = new FindLargestValueInEachTreeRow();
        System.out.println(obj.largestValues(root));
    }

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int nodesInLevel = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nodesInLevel; i++) {
                TreeNode currNode = queue.remove();
                max = Math.max(max, currNode.val);
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            list.add(max);
        }
        return list;
    }
}

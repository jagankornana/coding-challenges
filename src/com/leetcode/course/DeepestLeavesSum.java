package com.poc.practice;

import java.util.LinkedList;

public class DeepestLeavesSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        root.left = node1;
//        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node3.left = node6;

        DeepestLeavesSum obj = new DeepestLeavesSum();
        System.out.println(obj.deepestLeavesSum(root));
    }

    public int deepestLeavesSum(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int nodesInLevel = queue.size();
            int levelSum = 0;
            for (int i = 0; i < nodesInLevel; i++) {
                TreeNode currNode = queue.remove();
                levelSum += currNode.val;
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            sum = levelSum;
        }
        return sum;
    }
}

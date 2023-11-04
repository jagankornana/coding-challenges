package com.poc.practice;

public class PathSum {

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

//        node2.left = node5;

//        node5.right = node6;

        PathSum obj = new PathSum();
        System.out.println(obj.hasPathSum(root, 2));
    }

    public boolean hasPathSum(TreeNode node, int targetSum) {
        if (node == null) {
            return false;
        }
        targetSum -= node.val;
        if (node.left == null && node.right == null) {
            return targetSum == 0;
        }

        return hasPathSum(node.left, targetSum) || hasPathSum(node.right, targetSum);
    }

}

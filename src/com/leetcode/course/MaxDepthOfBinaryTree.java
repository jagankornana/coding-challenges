package com.poc.practice;

import java.util.Stack;

public class MaxDepthOfBinaryTree {

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

        node5.right = node6;

        MaxDepthOfBinaryTree obj = new MaxDepthOfBinaryTree();
        System.out.println(obj.maxDepth(root));
        System.out.println(obj.maxDepth_Iterative(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int maxDepth_Iterative(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> depths = new Stack<>();
        nodes.add(root);
        depths.add(1);
        int maxDepth = 0, currDepth = 0;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            currDepth = depths.pop();
            if (node != null) {
                maxDepth = Math.max(maxDepth, currDepth);
                nodes.add(node.left);
                depths.add(currDepth + 1);
                nodes.add(node.right);
                depths.add(currDepth + 1);
            }
        }

        return maxDepth;
    }
}

class TreeNode {
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

